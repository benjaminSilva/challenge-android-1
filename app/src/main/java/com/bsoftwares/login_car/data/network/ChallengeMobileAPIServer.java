package com.bsoftwares.login_car.data.network;

import com.bsoftwares.login_car.data.Model.AuthModel;
import com.bsoftwares.login_car.data.Model.CarDetailModel;
import com.bsoftwares.login_car.data.Model.CarOrdersModel;
import com.bsoftwares.login_car.data.Model.PerfilModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public class ChallengeMobileAPIServer {

    private Retrofit GetRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://challenge-mobile-api.liveonsolutions.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public interface API{
        @FormUrlEncoded
        @POST("auth/")
        Call<AuthModel> tryToAuthenticate(@Field("email") String user, @Field("password") String senha);

        @GET("user/profile")
        Call<PerfilModel> getUserData(@Query("token") String token);

        @GET("user/profile/orders")
        Call<List<CarOrdersModel>> getCarList(@Query("token") String token);

        @GET("user/profile/order_details")
        Call<CarDetailModel> getCarDetail(@Query("token") String token, @Query("order_id") int order_id);




    }

    public API getAPI(){
        return GetRetrofit()
                .create(API.class);
    }

}