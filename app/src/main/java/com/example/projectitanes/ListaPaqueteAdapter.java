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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.projectitanes.models.Paquete;

import java.util.ArrayList;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class ListaPaqueteAdapter extends RecyclerView.Adapter<ListaPaqueteAdapter.ViewHolder> {

    private ArrayList<Paquete> dataset;
    private Context context;

    public ListaPaqueteAdapter(){
        this.context = context;
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
        holder.costoTextView.setText(p.getCosto().toString() + " USD");

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.placeholder(R.drawable.ic_launcher_background);

        Glide.with(holder.photoImageView.getContext())
                .load(p.getPhotoURI())
                .centerCrop()
                .apply(requestOptions)
                .into(holder.photoImageView);

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
        private TextView costoTextView;
        private ImageView photoImageView;

        public ViewHolder(View itemView){
            super(itemView);
            photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);
            costoTextView = (TextView) itemView.findViewById(R.id.costoTextView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
        }
    }
}
