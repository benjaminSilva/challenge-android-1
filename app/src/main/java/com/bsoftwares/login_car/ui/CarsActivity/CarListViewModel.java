package com.bsoftwares.login_car.ui.CarsActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bsoftwares.login_car.data.Model.CarOrdersModel;
import com.bsoftwares.login_car.data.Model.PerfilModel;
import com.bsoftwares.login_car.data.network.ChallengeMobileAPIServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class CarListViewModel extends ViewModel {

    private MutableLiveData<List<CarOrdersModel>> carList;

    LiveData<List<CarOrdersModel>> listaCarros() {
        if (carList == null) {
            carList = new MutableLiveData<>();
        }
        return carList;
    }

    void getUserData(String token){
        ChallengeMobileAPIServer apiService = new ChallengeMobileAPIServer();
        apiService.getAPI().getCarList(token).enqueue(new Callback<List<CarOrdersModel>>() {
            @Override
            public void onResponse(Call<List<CarOrdersModel>> call, Response<List<CarOrdersModel>> response) {
                carList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CarOrdersModel>> call, Throwable t) {

            }
        });
    }
}
