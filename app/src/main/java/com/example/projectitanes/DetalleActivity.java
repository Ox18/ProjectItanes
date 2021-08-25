package com.example.projectitanes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectitanes.interfaces.LugarAPIService;
import com.example.projectitanes.models.Lugar;
import com.example.projectitanes.models.LugarRespuesta;
import com.example.projectitanes.models.Paquete;
import com.example.projectitanes.models.PaqueteRespuesta;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleActivity extends AppCompatActivity {

    private static final String TAG = "LUGARES";

    private Retrofit retrofit;

    private RecyclerView recyclerView;

    private TextView nombreTourTextView;

    private TextView description_paquete;
    private ListaLugarAdapter listaLugarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        nombreTourTextView = findViewById(R.id.nombreTourTextView);
        description_paquete = findViewById(R.id.description_paquete);

        // recuperar variable ingresada
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String description = extras.getString("description");
            String nombreTour = extras.getString("nombreTour");
            description_paquete.setText(description);
            nombreTourTextView.setText(nombreTour);

        }

        recyclerView = (RecyclerView)findViewById(R.id.recycleViewLugares);
        listaLugarAdapter = new ListaLugarAdapter();
        recyclerView.setAdapter(listaLugarAdapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://18.118.195.116:5500/")
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();

        obtenerDatos();
    }

    private void obtenerDatos(){
        LugarAPIService service = retrofit.create(LugarAPIService.class);
        Call<LugarRespuesta> lugarRespuestaCall = service.obtenerListaLugares();

        lugarRespuestaCall.enqueue(new Callback<LugarRespuesta>() {
            @Override
            public void onResponse(Call<LugarRespuesta> call, Response<LugarRespuesta> response) {
                if(response.isSuccessful()){
                    LugarRespuesta lugarRespuesta = response.body();
                    ArrayList<Lugar> listaLugar = lugarRespuesta.getResults();
                    listaLugarAdapter.adicionarListaLugar(listaLugar);
                }else{
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<LugarRespuesta> call, Throwable t) {
                Log.e(TAG, "onFailute: " + t.getMessage());
            }
        });
    }
}

