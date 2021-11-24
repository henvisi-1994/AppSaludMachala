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
import com.pulloquinga.app.models.CentroMedicoDB;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Especialidad;
import com.pulloquinga.app.models.Noticia;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_especialidades_db extends AppCompatActivity {
    private ApiService servicio = Config.getRetrofit().create(ApiService.class);
    ArrayList<DetalleCentroMedico> detalle_centros_medicos = new ArrayList();
    RecyclerView recycler;
    ArrayList<Especialidad> especialidades = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_especialidades_db);
        recycler = (RecyclerView) findViewById(R.id.lista_especialidades_db);
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        //recycler.setLayoutManager(new GridLayoutManager(this, 2));
        //int spanCount = 2; // 3 columns
       // int spacing = 30; // 50px
        //boolean includeEdge = false;
        //recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
    }

    public void InizializaDati() {
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        //try{
        Call<List<DetalleCentroMedico>> listCall;
        Call<List<Especialidad>> listCallaux;

        int id_centromedico = getIntent().getIntExtra("id_centromedico",0);
        Log.d("IdCENTROOOMEDICOOO",String.valueOf(id_centromedico));
        if(id_centromedico!=0){
            listCall = servicio.getDetalleCentroMedico();
            listCall.enqueue(new Callback<List<DetalleCentroMedico>>() {
                @Override
                public void onResponse(Call<List<DetalleCentroMedico>> call, Response<List<DetalleCentroMedico>> response) {
                    if (response.isSuccessful()) {
                        detalle_centros_medicos = (Recursos.listToArrayList(response.body()));
                        String tipo_medico = getIntent().getStringExtra("tipo_medico");
                        Log.d("CentroMedico", String.valueOf(id_centromedico));
                        AdapterEspecialidadesDB adapter = new AdapterEspecialidadesDB(detalle_centros_medicos,id_centromedico,tipo_medico);
                        recycler.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<DetalleCentroMedico>> call, Throwable t) {

                }
            });
        }else{
            listCallaux = servicio.getEspecialidadMedProd();
            listCallaux.enqueue(new Callback<List<Especialidad>>() {
                @Override
                public void onResponse(Call<List<Especialidad>> call, Response<List<Especialidad>> response) {
                    if (response.isSuccessful()) {
                        especialidades = (Recursos.listToArrayList(response.body()));
                        String tipo_medico = getIntent().getStringExtra("tipo_medico");
                        Log.d("CentroMedico", String.valueOf(id_centromedico));
                        AdapterEspecialidadesMP adapter = new AdapterEspecialidadesMP(especialidades,tipo_medico);
                        recycler.setAdapter(adapter);
                    }
                }
                @Override
                public void onFailure(Call<List<Especialidad>> call, Throwable t) {

                }
            });
        }


    }

}