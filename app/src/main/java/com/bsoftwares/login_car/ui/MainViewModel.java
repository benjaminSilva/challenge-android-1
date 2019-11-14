package com.bsoftwares.login_car.ui;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bsoftwares.login_car.data.Model.AuthModel;
import com.bsoftwares.login_car.data.network.ChallengeMobileAPIServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Usado AndroidViewModel para obter context e evitar memory leak
class MainViewModel extends ViewModel {

    private MutableLiveData<AuthModel> userToken;
    LiveData<AuthModel> getToken() {
        if (userToken == null) {
            userToken = new MutableLiveData<>();
        }
        return userToken;
    }

    void tryLogin(String usuario, String senha){
        ChallengeMobileAPIServer apiService = new ChallengeMobileAPIServer();
        apiService.getAPI().tryToAuthenticate(usuario,senha).enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                userToken.postValue(response.body());
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                userToken.postValue(null);
            }
        });
    }


}
