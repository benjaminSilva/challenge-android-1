package com.bsoftwares.login_car.ui.PerfilActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bsoftwares.login_car.data.Model.AuthModel;
import com.bsoftwares.login_car.data.Model.PerfilModel;
import com.bsoftwares.login_car.data.network.ChallengeMobileAPIServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<PerfilModel> userData;

    LiveData<PerfilModel> userData() {
        if (userData == null) {
            userData = new MutableLiveData<>();
        }
        return userData;
    }

    void getUserData(String token){
        ChallengeMobileAPIServer apiService = new ChallengeMobileAPIServer();
        apiService.getAPI().getUserData(token).enqueue(new Callback<PerfilModel>() {
            @Override
            public void onResponse(Call<PerfilModel> call, Response<PerfilModel> response) {
                userData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<PerfilModel> call, Throwable t) {

            }
        });
    }

}
