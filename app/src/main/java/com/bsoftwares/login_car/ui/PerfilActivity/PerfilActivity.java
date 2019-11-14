package com.bsoftwares.login_car.ui.PerfilActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bsoftwares.login_car.R;
import com.bsoftwares.login_car.Utils.Values;
import com.bsoftwares.login_car.data.Model.PerfilModel;
import com.bsoftwares.login_car.ui.CarsActivity.CarListActivity;
import com.squareup.picasso.Picasso;

public class PerfilActivity extends AppCompatActivity {

    TextView tv_name;
    TextView tv_city;
    ImageView userImage;
    RecyclerView recyclerView;
    Button btn_assinaturas;
    Button btn_sair;
    ProgressBar progressBar;
    private PerfilViewModel perfilViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        defineGlobalVariables();
        setObserver();
        perfilViewModel.getUserData(Values.getTOKEN());
    }

    private void setObserver() {
        perfilViewModel.userData().observe(this, new Observer<PerfilModel>() {
            @Override
            public void onChanged(PerfilModel perfilModel) {
                loadUI(perfilModel);
            }
        });
    }

    private void loadUI(PerfilModel perfilModel) {
        progressBar.setVisibility(View.GONE);
        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerfilActivity.this.finish();
            }
        });
        btn_assinaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this, CarListActivity.class));
            }
        });
        tv_name.setText(perfilModel.getFullname());
        tv_city.setText(perfilModel.getCity());
        Picasso.with(this)
                .load(perfilModel.getAvatar_url())
                .into(userImage);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new CarsAdapter(perfilModel.getOrders(),this));
        recyclerView.setOnFlingListener(null);
        new LinearSnapHelper().attachToRecyclerView(recyclerView);
    }

    private void defineGlobalVariables() {
        tv_name = findViewById(R.id.tv_name);
        tv_city = findViewById(R.id.tv_city);
        userImage = findViewById(R.id.civ_perfil);
        recyclerView = findViewById(R.id.recyclerViewCars);
        btn_assinaturas = findViewById(R.id.btn_minhasAssinaturas);
        btn_sair = findViewById(R.id.btn_logout);
        progressBar = findViewById(R.id.progressPerfil);
        perfilViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
    }
}
