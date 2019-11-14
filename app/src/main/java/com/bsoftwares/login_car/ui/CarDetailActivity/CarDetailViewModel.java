package com.bsoftwares.login_car.ui.CarDetailActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bsoftwares.login_car.data.Model.CarDetailModel;
import com.bsoftwares.login_car.data.Model.CarOrdersModel;
import com.bsoftwares.login_car.data.network.ChallengeMobileAPIServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarDetailViewModel extends ViewModel {

    private MutableLiveData<CarDetailModel> carDetail;

    LiveData<CarDetailModel> detalhesCarro() {
        if (carDetail == null) {
            carDetail = new MutableLiveData<>();
        }
        return carDetail;
    }

    void getCarDetail(String token, int carID){
        ChallengeMobileAPIServer apiService = new ChallengeMobileAPIServer();
        apiService.getAPI().getCarDetail(token,carID).enqueue(new Callback<CarDetailModel>() {
            @Override
            public void onResponse(Call<CarDetailModel> call, Response<CarDetailModel> response) {
                carDetail.postValue(response.body());
            }

            @Override
            public void onFailure(Call<CarDetailModel> call, Throwable t) {

            }
        });
    }

}
