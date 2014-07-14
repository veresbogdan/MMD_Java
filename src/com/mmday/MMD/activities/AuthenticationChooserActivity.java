package com.mmday.MMD.activities;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.mmday.MMD.R;
import com.mmday.MMD.models.GeneralEnums;

public class AuthenticationChooserActivity extends AccountAuthenticatorActivity implements AuthenticationChooserView, View.OnClickListener {

    private Button signIn;
    private Button signUp;
    private String mAuthTokenType;
    private AccountManager accountManager;

    private final int REQ_SIGN_IN = 1;
    private final int REQ_SIGN_UP = 2;

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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if ((requestCode == REQ_SIGN_IN || requestCode == REQ_SIGN_UP)&& resultCode == RESULT_OK) {
            finishLogin(intent);
        } else
            super.onActivityResult(requestCode, resultCode, intent);
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
}
