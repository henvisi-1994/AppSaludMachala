package com.pulloquinga.app;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class CentrosMedicos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_medicos);
    }
    public void item1(View view){
        Intent detalle = new Intent(this, DetalleCentroMedico.class);
        startActivity(detalle);
    }
}