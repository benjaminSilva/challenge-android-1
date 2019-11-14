package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

public class SummaryValueModel {
    @SerializedName("extras")
    private String extras;
    @SerializedName("monthly_price")
    private String monthly_price;
    @SerializedName("total_price")
    private String total_price;

    public String getExtras() {
        return extras;
    }

    public String getMonthly_price() {
        return monthly_price;
    }

    public String getTotal_price() {
        return total_price;
    }
}
