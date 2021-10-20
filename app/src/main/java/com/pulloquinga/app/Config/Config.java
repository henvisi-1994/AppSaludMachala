package com.pulloquinga.app.Config;

import android.content.Context;
import android.widget.Toast;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    //public static final String BASEURL="http://192.168.5.128/apiredsaludmachala/public/api/";
    //public static final String BASEURL="http://192.168.100.3/apiredsaludmachala/public/api/";
    public static final String BASEURL="https://apiapp.saludmachala.gob.ec/api/";


    public static Retrofit retrofit;
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()

                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static void Mensaje(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
    }



}
