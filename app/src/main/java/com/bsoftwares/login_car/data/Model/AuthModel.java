package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

public class AuthModel {
    @SerializedName("token")
    private
    String token;

    public String getToken() {
        return token;
    }

}
