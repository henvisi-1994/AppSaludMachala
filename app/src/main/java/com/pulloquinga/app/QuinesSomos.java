package com.pulloquinga.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class QuinesSomos extends AppCompatActivity {
    EditText editTextQuienesSomos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quines_somos);
        editTextQuienesSomos=(EditText) findViewById(R.id.editTextQuienesSomos);
        Recursos.texto_no_editable(editTextQuienesSomos);
    }
    public void fb(View view){
        startActivity(Recursos.enlaces("https://www.facebook.com/RedSaludMachala"));
    }
    public void tw(View view){
        startActivity(Recursos.enlaces("https://twitter.com/redsaludmachala"));
    }
    public void instagram(View view){
        startActivity(Recursos.enlaces("https://www.instagram.com/redsaludmachala/"));
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

}