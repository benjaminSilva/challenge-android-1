package com.bsoftwares.login_car.ui.CarDetailActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bsoftwares.login_car.R;
import com.bsoftwares.login_car.Utils.Values;
import com.bsoftwares.login_car.data.Model.CarDetailModel;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.List;

public class CarDetailActivity extends AppCompatActivity {

    TextView tv_fuel_type;
    TextView tv_engine_type;
    TextView tv_motor;
    TextView tv_tempoEntrega;
    TextView tv_preco;
    TextView tv_km;
    TextView tv_modelo_ano;
    TextView tv_marca_ano;
    TextView tv_modelo;
    TextView tv_portas;
    TextView tv_meses;
    TextView tv_km_rodado;
    TextView tv_km_adicional;
    SliderLayout sliderLayout;
    ProgressBar progressBar;
    ImageButton btn_back;
    private CarDetailViewModel carDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        defineGlobalVariables();
        setObservers();
        carDetailViewModel.getCarDetail(Values.getTOKEN(),Values.getCURRENT_CAR_ID());
    }

    private void setObservers() {
        carDetailViewModel.detalhesCarro().observe(this, new Observer<CarDetailModel>() {
            @Override
            public void onChanged(CarDetailModel carDetailModel) {
                loadUI(carDetailModel);
            }
        });
    }

    private void loadUI(CarDetailModel carDetailModel) {
        progressBar.setVisibility(View.GONE);
        tv_fuel_type.setText(carDetailModel.getVehicleDetailModel().getFuel_type());
        tv_engine_type.setText(carDetailModel.getVehicleDetailModel().getEngine_type());
        tv_motor.setText(getString(R.string.motor,carDetailModel.getVehicleDetailModel().getEngine()));
        tv_tempoEntrega.setText(getString(R.string.prazo,carDetailModel.getVehicleDetailModel().getDelivery_delay()));
        tv_preco.setText(getString(R.string.preco,carDetailModel.getSummaryValueModel().getMonthly_price()));
        tv_km.setText(getString(R.string.km,carDetailModel.getVehicleDetailModel().getKm()));
        tv_modelo_ano.setText(getString(R.string.marca_modelo_ano,carDetailModel.getVehicleDetailModel().getVehicle_model(),carDetailModel.getVehicleDetailModel().getVehicle_brand(),carDetailModel.getVehicleDetailModel().getVehicle_year()));
        tv_marca_ano.setText(getString(R.string.marca_ano,carDetailModel.getVehicleDetailModel().getVehicle_brand(),carDetailModel.getVehicleDetailModel().getVehicle_year()));
        tv_modelo.setText(carDetailModel.getVehicleDetailModel().getVehicle_model());
        tv_portas.setText(getString(R.string.qtd_portas,carDetailModel.getVehicleDetailModel().getDoors_qrd()));
        tv_meses.setText(getString(R.string.meses,carDetailModel.getSignatureDetailModel().getMonths()));
        tv_km_rodado.setText(getString(R.string.kilometros,carDetailModel.getSignatureDetailModel().getPlan_type()));
        tv_km_adicional.setText(getString(R.string.kmAdicional,carDetailModel.getSignatureDetailModel().getAdditional_franchise()));
        initSlider(carDetailModel.getVehicleDetailModel().getImage_url());
    }

    private void initSlider(List<String> image_url) {
        for (String imageUrl : image_url){
            sliderLayout.addSlider(
                    new DefaultSliderView(this)
                    .image(imageUrl)
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
            );
        }
    }

    private void defineGlobalVariables() {
        carDetailViewModel = ViewModelProviders.of(this).get(CarDetailViewModel.class);
        tv_fuel_type = findViewById(R.id.tv_gas);
        tv_engine_type = findViewById(R.id.tv_cambio);
        tv_motor = findViewById(R.id.tv_motor);
        tv_tempoEntrega = findViewById(R.id.tv_tempoEntrega);
        tv_preco = findViewById(R.id.tv_preco);
        tv_km = findViewById(R.id.tv_km);
        tv_modelo_ano = findViewById(R.id.tv_modelo_ano);
        tv_marca_ano = findViewById(R.id.tv_marca_ano);
        tv_modelo = findViewById(R.id.tv_modelo);
        tv_portas = findViewById(R.id.tv_portas);
        tv_meses = findViewById(R.id.tv_meses);
        tv_km_rodado = findViewById(R.id.tv_kmRodados);
        tv_km_adicional = findViewById(R.id.tv_kmAdicional);
        sliderLayout = findViewById(R.id.imageSlider);
        progressBar = findViewById(R.id.progressDetail);
        btn_back = findViewById(R.id.btn_backButtonCarDetail);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
