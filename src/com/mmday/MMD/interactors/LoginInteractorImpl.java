package com.mmday.MMD.interactors;

import com.mmday.MMD.presenters.OnLoginFinishedListener;
import com.mmday.MMD.rest.VolleyController;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginInteractorImpl implements LoginInteractor {

    private VolleyController volleyController = new VolleyController();

    @Override
    public void loginWithCredentials(final String username, final String password, final OnLoginFinishedListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override public void run() {
//                boolean error = false;
//                if (TextUtils.isEmpty(username)){
//                    listener.onUsernameError();
//                    error = true;
//                }
//                if (TextUtils.isEmpty(password)){
//                    listener.onPasswordError();
//                    error = true;
//                }
//                if (!error){
//                    listener.onSuccess();
//                }
//            }
//        }, 2000);
        Map<String, String> params = new HashMap<String, String>();
        params.put("NICKNAME", username);
        params.put("PASSWORD", password);

         volleyController.sendPostRequest(new JSONObject(params));
    }
}
