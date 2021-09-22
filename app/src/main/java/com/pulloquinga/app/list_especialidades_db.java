package com.pulloquinga.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_especialidades_db);
        recycler = (RecyclerView) findViewById(R.id.lista_especialidades_db);
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
        Call<List<DetalleCentroMedico>> listCall = servicio.getDetalleCentroMedico();
        listCall.enqueue(new Callback<List<DetalleCentroMedico>>() {
            @Override
            public void onResponse(Call<List<DetalleCentroMedico>> call, Response<List<DetalleCentroMedico>> response) {
                if (response.isSuccessful()) {
                    detalle_centros_medicos = (Recursos.listToArrayList(response.body()));
                    String tipo_medico = getIntent().getStringExtra("tipo_medico");
                    int id_centromedico = getIntent().getIntExtra("id_centromedico",0);
                    Log.d("CentroMedico", String.valueOf(id_centromedico));
                    AdapterEspecialidadesDB adapter = new AdapterEspecialidadesDB(detalle_centros_medicos,id_centromedico,tipo_medico);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<DetalleCentroMedico>> call, Throwable t) {

            }
        });
    }
}