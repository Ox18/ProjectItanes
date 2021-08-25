package com.example.projectitanes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectitanes.models.Paquete;

import java.util.ArrayList;

public class ListaPaqueteAdapter extends RecyclerView.Adapter<ListaPaqueteAdapter.ViewHolder> {

    private ArrayList<Paquete> dataset;

    public ListaPaqueteAdapter(){
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paquete, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paquete p = dataset.get(position);
        holder.nombreTextView.setText(p.getNombre());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPaquete(ArrayList<Paquete> listaPaquete) {
        dataset.addAll(listaPaquete);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreTextView;

        public ViewHolder(View itemView){
            super(itemView);

            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
        }
    }
}
