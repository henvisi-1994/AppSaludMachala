package com.pulloquinga.app.interfaces;

import com.pulloquinga.app.models.Noticia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("noticias")
    Call<List<Noticia>> getNoticias();
}
