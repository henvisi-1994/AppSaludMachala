package com.pulloquinga.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void centrosmedicos(View view){
        Intent cetroMedico = new Intent(this, CentrosMedicos.class);
        startActivity(cetroMedico);
    }
    public void jornadasmedicas(View view){
        Intent jornadasmedicas = new Intent(this, JornadasMedicas.class);
        startActivity(jornadasmedicas);
    }
    public void ambulancia(View view){
        Intent ambulancia = new Intent(this, Ambulancia.class);
        startActivity(ambulancia);
    }

    public void clinicas_moviles(View view){
        Intent clinicas_moviles = new Intent(this, ClinicasMoviles.class);
        startActivity(clinicas_moviles);
    }
    public void quienes_somos(View view){
        Intent quienes_somos = new Intent(this, QuinesSomos.class);
        startActivity(quienes_somos);
    }

}