package com.bsoftwares.login_car.data.Model;

import com.google.gson.annotations.SerializedName;

public class CarDetailModel {
    @SerializedName("signature_details")
    private SignatureDetailModel signatureDetailModel;
    @SerializedName("summary_values")
    private SummaryValueModel summaryValueModel;
    @SerializedName("vehicle_details")
    private VehicleDetailModel vehicleDetailModel;

    public SignatureDetailModel getSignatureDetailModel() {
        return signatureDetailModel;
    }

    public SummaryValueModel getSummaryValueModel() {
        return summaryValueModel;
    }

    public VehicleDetailModel getVehicleDetailModel() {
        return vehicleDetailModel;
    }
}
