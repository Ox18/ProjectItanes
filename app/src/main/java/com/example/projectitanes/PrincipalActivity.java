package com.example.projectitanes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectitanes.interfaces.PaqueteAPIService;
import com.example.projectitanes.models.Paquete;
import com.example.projectitanes.models.PaqueteRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrincipalActivity extends AppCompatActivity {

    private static final String TAG = "PAQUETES";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaPaqueteAdapter listaPaqueteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewPaquetes);
        listaPaqueteAdapter = new ListaPaqueteAdapter();
        recyclerView.setAdapter(listaPaqueteAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://18.118.195.116:5500/")
                .addConverterFactory(GsonConverterFactory
                .create())
                .build();

        obtenerDatos();
    }

    private void obtenerDatos(){
        PaqueteAPIService service = retrofit.create(PaqueteAPIService.class);
        Call<PaqueteRespuesta> paqueteRespuestaCall = service.obtenerListaPaquetes();

        paqueteRespuestaCall.enqueue(new Callback<PaqueteRespuesta>() {
            @Override
            public void onResponse(Call<PaqueteRespuesta> call, Response<PaqueteRespuesta> response) {
                if(response.isSuccessful()){
                    PaqueteRespuesta paqueteRespuesta = response.body();
                    ArrayList<Paquete> listaPaquete = paqueteRespuesta.getResults();
                    Toast.makeText(PrincipalActivity.this, "Todo ok, is llegaron" + listaPaquete.size(), Toast.LENGTH_SHORT).show();
                    listaPaqueteAdapter.adicionarListaPaquete(listaPaquete);

                }else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PaqueteRespuesta> call, Throwable t) {
                Log.e(TAG, "onFailute: " + t.getMessage());
            }
        });

    }


}
