package com.pulloquinga.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.pulloquinga.app.models.CentroMedico;

import java.util.ArrayList;

public class CitasPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recycler;
        ArrayList<String> tipo_medico=new ArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_principal);
        recycler=(RecyclerView) findViewById(R.id.lista_tipo_medicos);
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        int spanCount = 2; // 3 columns
        int spacing = 30; // 50px
        boolean includeEdge = false;
        recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        String[] aux ={"Medico Fijo","Medico de Produccion"};
        for (int i=0;i<=(aux.length-1);i++){
            tipo_medico.add(aux[i]);
        }
        AdapterTiposMedicos adapter=new AdapterTiposMedicos(tipo_medico);
        recycler.setAdapter(adapter);

    }
}
