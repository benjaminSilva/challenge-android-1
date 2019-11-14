package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

public class CarOrdersModel {
    @SerializedName("order_id")
    private int order_id;
    @SerializedName("submodel_name")
    private String submodel_name;

    public int getOrder_id() {
        return order_id;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }
}
