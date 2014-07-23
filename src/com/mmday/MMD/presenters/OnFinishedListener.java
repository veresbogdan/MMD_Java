package com.mmday.MMD.presenters;

public interface OnFinishedListener {
    //TODO: use this instead of OnLoginFinishedListener
    //(add an errorInfo param - interface - and customize it were needed

    public void onError();

    public void onSuccess();
}
