package com.mmday.MMD.activities;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.mmday.MMD.R;
import com.mmday.MMD.models.GeneralEnums;
import com.mmday.MMD.presenters.SignUpPresenter;
import com.mmday.MMD.presenters.SignUpPresenterImpl;

public class SignUpActivity extends Activity implements SignUpView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private EditText email;
    private SignUpPresenter presenter;

    public static final String KEY_ERROR_MESSAGE = "ERR_MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        progressBar = (ProgressBar) findViewById(R.id.progress_sign_up);
        username = (EditText) findViewById(R.id.username_field);
        password = (EditText) findViewById(R.id.password_field);
        email = (EditText) findViewById(R.id.email_field);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new SignUpPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setEmailError() {
        email.setError(getString(R.string.email_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void setUpUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        presenter.showProgress();
        final String accountType = getIntent().getStringExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue());

        new AsyncTask<String, Void, Intent>() {
            @Override
            protected Intent doInBackground(String... params) {
                String authToken;
                Bundle data = new Bundle();
                try {
                    authToken = presenter.signUpWithCredentials(username.getText().toString(), password.getText().toString(), email.getText().toString(), null);

                    data.putString(AccountManager.KEY_ACCOUNT_NAME, email.getText().toString());
                    data.putString(AccountManager.KEY_ACCOUNT_TYPE, accountType);
                    data.putString(AccountManager.KEY_AUTHTOKEN, authToken);
                    data.putString(GeneralEnums.PARAM_USER_PASS.getValue(), password.getText().toString());

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
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }.execute();
    }
}
