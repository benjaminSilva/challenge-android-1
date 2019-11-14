package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderModel {
    @SerializedName("order_id")
    private
    int order_id;
    @SerializedName("submodel_name")
    private
    String submodel_name;
    @SerializedName("statuses")
    private
    List<StatusesModel> statuses;

    public int getOrder_id() {
        return order_id;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }

    public List<StatusesModel> getStatuses() {
        return statuses;
    }
}
