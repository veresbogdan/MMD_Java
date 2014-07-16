package com.mmday.MMD.presenters;

public interface OnLoginFinishedListener {

    public void onEmailError();

    public void onPasswordError();

    public void onSuccess();
}
