package com.bsoftwares.login_car.ui.CarsActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bsoftwares.login_car.R;
import com.bsoftwares.login_car.Utils.Values;
import com.bsoftwares.login_car.data.Model.CarOrdersModel;
import com.bsoftwares.login_car.ui.PerfilActivity.CarsAdapter;

import java.util.List;

public class CarListActivity extends AppCompatActivity {

    ImageButton btn_back;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    private CarListViewModel carListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        defineGlobalVariables();
        setObservers();
        carListViewModel.getUserData(Values.getTOKEN());
    }

    private void setObservers() {
        carListViewModel.listaCarros().observe(this, new Observer<List<CarOrdersModel>>() {
            @Override
            public void onChanged(List<CarOrdersModel> carOrdersModel) {
                loadUI(carOrdersModel);
            }
        });
    }

    private void loadUI(List<CarOrdersModel> carOrdersModel) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(new CarListAdapter(this,carOrdersModel));
    }

    private void defineGlobalVariables() {
        btn_back = findViewById(R.id.btn_backButtonList);
        recyclerView = findViewById(R.id.rv_carList);
        progressBar = findViewById(R.id.progressList);
        carListViewModel = ViewModelProviders.of(this).get(CarListViewModel.class);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
