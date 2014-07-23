package com.mmday.MMD.models;

public enum GeneralEnums {
    ARG_AUTH_TYPE("AUTH_TYPE"),
    ARG_ACCOUNT_NAME("ACCOUNT_NAME"),
    ARG_IS_ADDING_NEW_ACCOUNT("IS_ADDING_ACCOUNT"),
    AUTHTOKEN_TYPE_FULL_ACCESS("Full access"),
    ARG_ACCOUNT_TYPE("ACCOUNT_TYPE"),
    ACCOUNT_TYPE("com.mmday.MMD"),
    PARAM_USER_PASS("USER_PASS"),
    API_URL_ENDPOINT("http://api.mm-day.com"),

    PARAM_CATEGORY_ID("categoryId"),
    PARAM_IMAGE_ID("imageId");

    private final String value;

    GeneralEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
