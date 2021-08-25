package com.example.projectitanes.interfaces;

import com.example.projectitanes.models.LugarRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LugarAPIService {
    @GET("lugar/only/paquete/12")
    Call<LugarRespuesta> obtenerListaLugares();
}
