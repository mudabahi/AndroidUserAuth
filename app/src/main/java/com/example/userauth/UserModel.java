package com.example.userauth;

public class UserModel {
    String email;
    String password;
    String userUID;

    public UserModel(String email, String password, String userUID) {
        this.email = email;
        this.password = password;
        this.userUID = userUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }
}
