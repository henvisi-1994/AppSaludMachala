package com.pulloquinga.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;



public class Noticias extends AppCompatActivity {
    ArrayList<Noticia> noticias = new ArrayList();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        recycler=(RecyclerView) findViewById(R.id.recycler_noticias);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        //recycler.setLayoutManager(new GridLayoutManager(this,2));
        InizializaDati();
        AdapterNoticias adapter=new AdapterNoticias(noticias);
        recycler.setAdapter(adapter);
    }
    public  void InizializaDati(){
        noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        noticias.add(new Noticia(2,"Titulo2","gdfgdfgdfgdf","sfsdfsdfsd"));
        noticias.add(new Noticia(3,"Titulo2","gdfgdfgdfgdf","sfsdfsdfsd"));

    }
    public void inicio(View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
}