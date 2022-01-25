package com.example.kjra.api;

import com.example.kjra.model.Biblia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    //obtiene las tarjetas para mostrarlas en el menu
    @GET("biblia")
    Call<List<Biblia>> getListBiblia();
}
