package com.example.projectitanes.interfaces;

import com.example.projectitanes.models.PaqueteRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PaqueteAPIService {
    @GET("paquete")
    Call<PaqueteRespuesta> obtenerListaPaquetes();
}
