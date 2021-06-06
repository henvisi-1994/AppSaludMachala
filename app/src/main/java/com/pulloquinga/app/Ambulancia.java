package com.pulloquinga.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ambulancia extends AppCompatActivity {
    EditText editTextAmbulancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulancia);
        editTextAmbulancia=(EditText) findViewById(R.id.editTextAmbulancia);
        Recursos.texto_no_editable(editTextAmbulancia);
    }
    public void inicio(View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
    public void noticias(View view){
        Intent noticias = new Intent(this, Noticias.class);
        startActivity(noticias);
    }
}