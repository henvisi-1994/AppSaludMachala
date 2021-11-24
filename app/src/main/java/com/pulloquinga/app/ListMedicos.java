package com.pulloquinga.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Especialidad;
import com.pulloquinga.app.models.Medico;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMedicos extends AppCompatActivity {
    private ApiService servicio = Config.getRetrofit().create(ApiService.class);
    ArrayList<Medico> medicos = new ArrayList();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_medicos);
        recycler = (RecyclerView) findViewById(R.id.lista_medicos);
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        //recycler.setLayoutManager(new GridLayoutManager(this, 2));
        //int spanCount = 2; // 3 columns
        //int spacing = 30; // 50px
        //boolean includeEdge = false;
        //recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
    }
    public void InizializaDati() {
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        //try{
        String tipo_medico = getIntent().getStringExtra("tipo_medico");
        Call<List<Medico>> listCall;
        switch(tipo_medico){
            case "Medico Fijo":
                listCall = servicio.getMedico();
                break;
            case "Medico Produccion":
                listCall = servicio.getMedicoProduccion();
                break;
            default:
                throw new IllegalStateException("No existe Tipo Medico: " + tipo_medico);
        }
        listCall.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                if (response.isSuccessful()) {
                    medicos = (Recursos.listToArrayList(response.body()));
                    int id_especialidad = getIntent().getIntExtra("id_especialidad",0);
                    int id_centroM = getIntent().getIntExtra("id_centroM",0);
                    Log.d("Especialidad", String.valueOf(id_especialidad));
                    AdapterMedico adapter = new AdapterMedico(medicos,id_especialidad,tipo_medico,id_centroM);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
                Log.d("ERROR" ,t.getMessage());
            }
        });
    }

}