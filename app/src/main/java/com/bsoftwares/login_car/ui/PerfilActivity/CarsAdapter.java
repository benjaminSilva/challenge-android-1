package com.bsoftwares.login_car.ui.PerfilActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsoftwares.login_car.R;
import com.bsoftwares.login_car.Utils.Values;
import com.bsoftwares.login_car.data.Model.OrderModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarViewHolder> {

    private List<OrderModel> pedidos;
    private Context contextForStrings;

    CarsAdapter(List<OrderModel> orders, Context context){
        pedidos = orders;
        contextForStrings = context;
    }

    @NotNull
    @Override
    public CarsAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item,parent,false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.CarViewHolder holder, int position) {
        holder.carName.setText(contextForStrings.getString(R.string.carroModel,pedidos.get(position).getOrder_id(),pedidos.get(position).getSubmodel_name()));
        holder.cb01.setChecked(pedidos.get(position).getStatuses().get(0).getChecked());
        holder.cb02.setChecked(pedidos.get(position).getStatuses().get(1).getChecked());
        holder.cb03.setChecked(pedidos.get(position).getStatuses().get(2).getChecked());
        holder.cb04.setChecked(pedidos.get(position).getStatuses().get(3).getChecked());
        holder.cb05.setChecked(pedidos.get(position).getStatuses().get(4).getChecked());
        holder.cb06.setChecked(pedidos.get(position).getStatuses().get(5).getChecked());
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    class CarViewHolder extends RecyclerView.ViewHolder{

        TextView carName;
        CheckBox cb01;
        CheckBox cb02;
        CheckBox cb03;
        CheckBox cb04;
        CheckBox cb05;
        CheckBox cb06;

        public CarViewHolder(View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.tv_numberCar);
            cb01 = itemView.findViewById(R.id.cb_aprovacaoPendente);
            cb02 = itemView.findViewById(R.id.cb_contratoAprovado);
            cb03 = itemView.findViewById(R.id.cb_pedidoFeito);
            cb04 = itemView.findViewById(R.id.cb_carroEstoque);
            cb05 = itemView.findViewById(R.id.cb_agendamentoEntrega);
            cb06 = itemView.findViewById(R.id.cb_carroEntregue);

        }
    }

}

