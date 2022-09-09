package com.pulloquinga.app.Config;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigCard {
    public static final String BASEURL="https://ccapi.paymentez.com/v2/card/";


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
