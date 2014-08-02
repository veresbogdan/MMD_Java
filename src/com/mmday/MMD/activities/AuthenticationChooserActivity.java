package com.mmday.MMD.activities;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.facebook.*;
import com.facebook.model.GraphUser;
import com.mmday.MMD.R;
import com.mmday.MMD.models.GeneralEnums;
import com.mmday.MMD.models.UserDto;
import com.mmday.MMD.presenters.FbLoginPresenter;
import com.mmday.MMD.presenters.FbLoginPresenterImpl;

import java.util.Arrays;

public class AuthenticationChooserActivity extends AccountAuthenticatorActivity implements AuthenticationChooserView, View.OnClickListener {

    private Button signIn;
    private Button signUp;
    private Button fbSignIn;
    private String mAuthTokenType;
    private AccountManager accountManager;

    private Session.StatusCallback statusCallback = new SessionStatusCallback();

    private final int REQ_SIGN_IN = 1;
    private final int REQ_SIGN_UP = 2;
    public static final String KEY_ERROR_MESSAGE = "ERR_MSG";

    private FbLoginPresenter fbLoginPresenter;

    //TODO Modularize this + remove unnecessary code from FB part
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.authentication_chooser);

        accountManager = AccountManager.get(getBaseContext());
        mAuthTokenType = getIntent().getStringExtra(GeneralEnums.ARG_AUTH_TYPE.getValue());
        if (mAuthTokenType == null) {
            mAuthTokenType = GeneralEnums.AUTHTOKEN_TYPE_FULL_ACCESS.getValue();
        }

        signIn = (Button) findViewById(R.id.SignInButton);
        signIn.setOnClickListener(this);
        signUp = (Button) findViewById(R.id.SignUpButton);
        signUp.setOnClickListener(this);
        fbSignIn = (Button) findViewById(R.id.FbSignInButton);
        fbSignIn.setOnClickListener(this);

        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        Session session = Session.getActiveSession();
        if (session == null) {
            if (savedInstanceState != null) {
                session = Session.restoreSession(this, null, statusCallback, savedInstanceState);
            }
            if (session == null) {
                session = new Session(this);
            }
            Session.setActiveSession(session);
            if (session.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
                Session.OpenRequest request = new Session.OpenRequest(this);
                request.setPermissions(Arrays.asList("public_profile","user_friends","email","user_location"));
                request.setCallback(statusCallback);

                session.openForRead(request);
            }
        }

        fbLoginPresenter = new FbLoginPresenterImpl();
    }

    @Override
    public void onStart() {
        super.onStart();
        Session.getActiveSession().addCallback(statusCallback);
    }

    @Override
    public void onStop() {
        super.onStop();
        Session.getActiveSession().removeCallback(statusCallback);
    }

    @Override
    public void onClick(View view) {
        String accountType = getIntent().getStringExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue());

        if (view == signIn) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue(), accountType);

            startActivityForResult(intent, REQ_SIGN_IN);
        }
        if (view == signUp) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            intent.putExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue(), accountType);

            startActivityForResult(intent, REQ_SIGN_UP);
        }
        if (view == fbSignIn) {
            Session session = Session.getActiveSession();
            if (!session.isOpened() && !session.isClosed()) {
                Session.OpenRequest request = new Session.OpenRequest(this);
                request.setPermissions(Arrays.asList("public_profile","user_friends","email","user_location"));
                request.setCallback(statusCallback);

                session.openForRead(request);
            } else {
                Session.openActiveSession(this, true, statusCallback);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_SIGN_IN || requestCode == REQ_SIGN_UP) {
                finishLogin(intent);
            } else {
                Session.getActiveSession().onActivityResult(this, requestCode, resultCode, intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Session session = Session.getActiveSession();
        Session.saveSession(session, outState);
    }

    private void updateView() {
        Session session = Session.getActiveSession();
        if (session.isOpened()) {
            getFacebookUserID(session);
        }
    }

    private void sendFbLoginToServer(final Session session, final String userId) {
        final String accountType = getIntent().getStringExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue());

        new AsyncTask<String, Void, Intent>() {
            @Override
            protected Intent doInBackground(String... params) {
                UserDto userDto;
                Bundle data = new Bundle();
                try {
                    userDto = fbLoginPresenter.loginWithFacebook(session.getAccessToken(), userId);

                    data.putString(AccountManager.KEY_ACCOUNT_NAME, userDto.getEmail());
                    data.putString(AccountManager.KEY_ACCOUNT_TYPE, accountType);
                    data.putString(AccountManager.KEY_AUTHTOKEN, userDto.getToken());

                    //TODO possible to need the generated pass

                } catch (Exception e) {
                    data.putString(KEY_ERROR_MESSAGE, e.getMessage());
                }

                final Intent res = new Intent();
                res.putExtras(data);
                return res;
            }

            @Override
            protected void onPostExecute(Intent intent) {
                if (intent.hasExtra(KEY_ERROR_MESSAGE)) {
                    Toast.makeText(getBaseContext(), intent.getStringExtra(KEY_ERROR_MESSAGE), Toast.LENGTH_SHORT).show();
                } else {
                    finishLogin(intent);
                }
            }
        }.execute();
    }

    private void getFacebookUserID(final Session session) {
        Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {
            @Override
            public void onCompleted(GraphUser user, Response response) {
                // If the response is successful
                if (session == Session.getActiveSession()) {
                    if (user != null) {
                        sendFbLoginToServer(session, user.getId());
                    }
                }
            }
        });
        Request.executeBatchAsync(request);
    }

    private void finishLogin(Intent intent) {
        String accountName = intent.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
        String accountPassword = intent.getStringExtra(GeneralEnums.PARAM_USER_PASS.getValue());
        final Account account = new Account(accountName, intent.getStringExtra(AccountManager.KEY_ACCOUNT_TYPE));

        if (getIntent().getBooleanExtra(GeneralEnums.ARG_IS_ADDING_NEW_ACCOUNT.getValue(), false)) {
            String authToken = intent.getStringExtra(AccountManager.KEY_AUTHTOKEN);
            String authTokenType = mAuthTokenType;

            // Creating the account on the device and setting the auth token we got
            // (Not setting the auth token will cause another call to the server to authenticate the user)
            accountManager.addAccountExplicitly(account, accountPassword, null);
            accountManager.setAuthToken(account, authTokenType, authToken);
        } else {
            accountManager.setPassword(account, accountPassword);
        }

        setAccountAuthenticatorResult(intent.getExtras());
        setResult(RESULT_OK, intent);
        finish();
    }

    private class SessionStatusCallback implements Session.StatusCallback {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            updateView();
        }
    }
}
