package com.pulloquinga.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Noticia;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Noticias extends AppCompatActivity {
    private ApiService servicio= Config.getRetrofit().create(ApiService.class);

    ArrayList<Noticia> noticias=new ArrayList();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        recycler=(RecyclerView) findViewById(R.id.recycler_noticias);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        //recycler.setLayoutManager(new GridLayoutManager(this,2));
        InizializaDati();


    }
    public  void InizializaDati(){
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        //try{
            Call<List<Noticia>> listCall=servicio.getNoticias();
            listCall.enqueue(new Callback<List<Noticia>>() {
                @Override
                public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                    if (response.isSuccessful()){
                        noticias=(Recursos.listToArrayList(response.body()));
                        AdapterNoticias adapter=new AdapterNoticias(noticias);
                        recycler.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Noticia>> call, Throwable t) {
                    Log.d("ERROR" ,t.getMessage());

                }
            });
       // }
       // catch (Exception e){
       //     Log.e("ERROR", e.toString());

      //  }


    }
    public void inicio(View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
}