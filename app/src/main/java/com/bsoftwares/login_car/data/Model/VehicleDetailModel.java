package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleDetailModel {
    @SerializedName("delivery_delay")
    private int delivery_delay;
    @SerializedName("doors_qtd")
    private int doors_qrd;
    @SerializedName("engine")
    private String engine;
    @SerializedName("engine_type")
    private String engine_type;
    @SerializedName("fuel_type")
    private String fuel_type;
    @SerializedName("image_url")
    private List<String> image_url;
    @SerializedName("km")
    private int km;
    @SerializedName("vehicle_brand")
    private String vehicle_brand;
    @SerializedName("vehicle_model")
    private String vehicle_model;
    @SerializedName("vehicle_year")
    private int vehicle_year;

    public int getDelivery_delay() {
        return delivery_delay;
    }

    public int getDoors_qrd() {
        return doors_qrd;
    }

    public String getEngine() {
        return engine;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public List<String> getImage_url() {
        return image_url;
    }

    public int getKm() {
        return km;
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public int getVehicle_year() {
        return vehicle_year;
    }
}
