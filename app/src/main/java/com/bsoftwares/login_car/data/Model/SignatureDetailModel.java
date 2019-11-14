package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

public class SignatureDetailModel{
    @SerializedName("additional_franchise")
    private String additional_franchise;
    @SerializedName("months")
    private int months;
    @SerializedName("plan_type")
    private int plan_type;

    public String getAdditional_franchise() {
        return additional_franchise;
    }

    public int getMonths() {
        return months;
    }

    public int getPlan_type() {
        return plan_type;
    }
}
