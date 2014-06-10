package com.mmday.MMD.activities.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticatorBinder extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        Authenticator authenticator = new Authenticator(this);

        return authenticator.getIBinder();
    }
}
