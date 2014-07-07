package com.mmday.MMD.activities;

import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.mmday.MMD.R;
import com.mmday.MMD.models.GeneralEnums;

public class AuthenticationChooserActivity extends AccountAuthenticatorActivity implements AuthenticationChooserView, View.OnClickListener {

    private Button signIn;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.authentication_chooser);

        signIn = (Button) findViewById(R.id.SignInButton);
        signIn.setOnClickListener(this);
        signUp = (Button) findViewById(R.id.SignUpButton);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == signIn) {
            String accountType = getIntent().getStringExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue());
            Boolean isAddingNewAccount = getIntent().getBooleanExtra(GeneralEnums.ARG_IS_ADDING_NEW_ACCOUNT.getValue(), false);

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(GeneralEnums.ARG_ACCOUNT_TYPE.getValue(), accountType);
            intent.putExtra(GeneralEnums.ARG_IS_ADDING_NEW_ACCOUNT.getValue(), isAddingNewAccount);

            startActivity(intent);
            finish();
        }
        if (view == signUp) {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        }
    }
}
