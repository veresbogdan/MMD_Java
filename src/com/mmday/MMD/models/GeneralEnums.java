package com.mmday.MMD.models;

public enum GeneralEnums {
    ARG_AUTH_TYPE("AUTH_TYPE"),
    ARG_ACCOUNT_NAME("ACCOUNT_NAME"),
    ARG_IS_ADDING_NEW_ACCOUNT("IS_ADDING_ACCOUNT"),
    AUTHTOKEN_TYPE_FULL_ACCESS("Full access"),
    ARG_ACCOUNT_TYPE("ACCOUNT_TYPE"),
    ACCOUNT_TYPE("com.mmday.MMD");

    private final String message;

    GeneralEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
