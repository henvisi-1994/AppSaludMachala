package com.pulloquinga.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        int spanCount = 2; // 3 columns
        int spacing = 30; // 50px
        boolean includeEdge = false;
        recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
    }
    public void InizializaDati() {
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        //try{
        Call<List<Medico>> listCall = servicio.getMedico();
        listCall.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                if (response.isSuccessful()) {
                    medicos = (Recursos.listToArrayList(response.body()));
                    String tipo_medico = getIntent().getStringExtra("tipo_medico");
                    int id_especialidad = getIntent().getIntExtra("id_especialidad",0);
                    Log.d("Especialidad", String.valueOf(id_especialidad));
                    AdapterMedico adapter = new AdapterMedico(medicos,id_especialidad,tipo_medico);
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