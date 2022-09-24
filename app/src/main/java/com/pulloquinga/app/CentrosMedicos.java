package com.pulloquinga.app;

import android.content.Intent;


import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.CentroMedico;
import com.pulloquinga.app.models.CentroMedicoDB;
import com.pulloquinga.app.models.DetalleCentroMedico;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CentrosMedicos extends AppCompatActivity {
    ArrayList<CentroMedico> centrosmedicos = new ArrayList();
    ArrayList<CentroMedicoDB> centrosmedicosdb = new ArrayList();
    ArrayList<DetalleCentroMedico>obtenercentrosmedicos=new ArrayList();
    private ApiService servicio= Config.getRetrofit().create(ApiService.class);
    RecyclerView recycler;
    ProgressBar pbcm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_medicos);
        Log.d("Metodo visibilidad222","Centro medico");
        recycler=(RecyclerView) findViewById(R.id.recycler_cm);
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        pbcm2=(ProgressBar)findViewById(R.id.pbcm2);
        this.visible(false);
        InizializaDati();
        AdapterCentrosMedicos adapter=new AdapterCentrosMedicos(centrosmedicos);
        recycler.setAdapter(adapter);
        //obtener_datosbd();

    }
    public  void InizializaDati(){
        this.visible(true);

        Log.d("METODOCM","LLegoCM");
        Call<List<CentroMedicoDB>> listCall=servicio.getCentrosMedicos();
        listCall.enqueue(new Callback<List<CentroMedicoDB>>() {
            @Override
            public void onResponse(Call<List<CentroMedicoDB>> call, Response<List<CentroMedicoDB>> response) {

                if (response.isSuccessful()){
                    visible(false);
                    centrosmedicosdb=(Recursos.listToArrayList(response.body()));
                    for(int i=0;i<=centrosmedicosdb.size()-1;i++){
                        centrosmedicos.add(new CentroMedico(centrosmedicosdb.get(i).getId_centroMedico(),centrosmedicosdb.get(i).getNombre_centroMedico(),centrosmedicosdb.get(i).getDireccion_centroMedico(),centrosmedicosdb.get(i).getTelef_centroMedico(),centrosmedicosdb.get(i).getUbic_centroMedico()));
                    }

                    AdapterCentrosMedicos adapter=new AdapterCentrosMedicos(centrosmedicos);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CentroMedicoDB>> call, Throwable t) {
                Log.d("ERROR" ,t.getMessage());

            }
        });
    }

    public void inicio(View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
    public void noticias(View view){
        Intent noticias = new Intent(this, Noticias.class);
        startActivity(noticias);
        finish();
    }
    public void contacto(View view){
        Intent contacto = new Intent(this, Contacto.class);
        startActivity(contacto);
        finish();
    }
    public void visible(boolean visibilidad){
        if (visibilidad) {

            pbcm2.setVisibility(View.VISIBLE);
            recycler.setVisibility(View.GONE);
        }
        else {
            pbcm2.setVisibility(View.GONE);
            recycler.setVisibility(View.VISIBLE);

        }
    }

}