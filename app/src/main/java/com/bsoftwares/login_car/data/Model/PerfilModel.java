package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PerfilModel {
    @SerializedName("avatar_url")
    private
    String avatar_url;
    @SerializedName("city")
    private
    String city;
    @SerializedName("fullname")
    private
    String fullname;
    @SerializedName("orders")
    private
    List<OrderModel> orders;

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getCity() {
        return city;
    }

    public String getFullname() {
        return fullname;
    }

    public List<OrderModel> getOrders() {
        return orders;
    }

}
