package com.mmday.MMD.models;

import com.google.gson.annotations.SerializedName;

public class UserEntity {

    @SerializedName("NICKNAME")
    private String username;

    @SerializedName("PASSWORD")
    private String password;

    @SerializedName("EMAIL")
    private String email;

    @SerializedName("LOCATION")
    private String location;

    @SerializedName("TOKEN")
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
