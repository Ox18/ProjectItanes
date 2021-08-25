package com.example.projectitanes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projectitanes.models.Lugar;

import java.util.ArrayList;

public class ListaLugarAdapter extends RecyclerView.Adapter<ListaLugarAdapter.ViewHolder> {
    private ArrayList<Lugar> dataset;
    private Context context;

    public ListaLugarAdapter(){
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lugar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaLugarAdapter.ViewHolder holder, int position) {
        Lugar l = dataset.get(position);
        holder.titulo_lugar.setText(l.getNombre());
        holder.descripcion_lugar.setText(l.getDescripcion());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.placeholder(R.drawable.ic_launcher_background);

        Glide.with(holder.image_lugar.getContext())
                .load(l.getPhotoURI())
                .centerCrop()
                .apply(requestOptions)
                .into(holder.image_lugar);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaLugar(ArrayList<Lugar> listaLugar) {
        dataset.addAll(listaLugar);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context contexto;
        private TextView titulo_lugar;
        private ImageView image_lugar;
        private TextView descripcion_lugar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            image_lugar = (ImageView)itemView.findViewById(R.id.image_lugar);
            titulo_lugar = (TextView)itemView.findViewById(R.id.titulo_lugar);
            descripcion_lugar = (TextView)itemView.findViewById(R.id.description_lugar);
        }
    }
}
