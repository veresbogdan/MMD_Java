package com.mmday.MMD.activities;

import android.app.Activity;
import android.os.Bundle;
import com.mmday.MMD.R;

public class SignUpActivity extends Activity implements SignUpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
    }
}
