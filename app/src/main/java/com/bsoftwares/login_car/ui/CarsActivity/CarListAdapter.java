package com.bsoftwares.login_car.ui.CarsActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bsoftwares.login_car.R;
import com.bsoftwares.login_car.Utils.Values;
import com.bsoftwares.login_car.data.Model.CarOrdersModel;
import com.bsoftwares.login_car.ui.CarDetailActivity.CarDetailActivity;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarsViewHolder> {

    private Context contextParaStartActvitiy;
    private List<CarOrdersModel> carros;


    CarListAdapter(Context context, List<CarOrdersModel> cars){
        contextParaStartActvitiy = context;
        carros = cars;
    }

    @NonNull
    @Override
    public CarListAdapter.CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_assinatura_item,parent,false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, final int position) {
        holder.carName.setText(carros.get(position).getSubmodel_name());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Values.setCURRENT_CAR_ID(carros.get(position).getOrder_id());
                contextParaStartActvitiy.startActivity(new Intent(contextParaStartActvitiy,CarDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    class CarsViewHolder extends RecyclerView.ViewHolder {

        TextView carName;
        ConstraintLayout container;

        CarsViewHolder(@NonNull View itemView) {
            super(itemView);

            carName = itemView.findViewById(R.id.tv_carModelAssinatura);
            container = itemView.findViewById(R.id.car_assinatura_item_container);

        }
    }

}
