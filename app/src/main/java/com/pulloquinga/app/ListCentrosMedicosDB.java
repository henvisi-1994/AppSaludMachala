package com.pulloquinga.app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.CentroMedicoDB;
import com.pulloquinga.app.models.Noticia;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCentrosMedicosDB extends AppCompatActivity {
    private ApiService servicio= Config.getRetrofit().create(ApiService.class);
    ArrayList<CentroMedicoDB> centrosmedicos=new ArrayList();
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_centros_medicos_db);
        recycler=(RecyclerView) findViewById(R.id.lista_centros_medicos_db);
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        //recycler.setLayoutManager(new GridLayoutManager(this,2));
       // int spanCount = 2; // 3 columns
        //int spacing = 30; // 50px
        //boolean includeEdge = false;
        //recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
    }
    public  void InizializaDati(){
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        //try{
        Call<List<CentroMedicoDB>> listCall=servicio.getCentrosMedicos();
        listCall.enqueue(new Callback<List<CentroMedicoDB>>() {
            @Override
            public void onResponse(Call<List<CentroMedicoDB>> call, Response<List<CentroMedicoDB>> response) {
                if (response.isSuccessful()){
                    centrosmedicos=(Recursos.listToArrayList(response.body()));
                    String tipo_medico = getIntent().getStringExtra("tipo_medico");
                    AdapterCentrosMedicosDB adapter=new AdapterCentrosMedicosDB(centrosmedicos,tipo_medico);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CentroMedicoDB>> call, Throwable t) {
                Log.d("ERROR" ,t.getMessage());

            }
        });
        // }
        // catch (Exception e){
        //     Log.e("ERROR", e.toString());

        //  }


    }
}