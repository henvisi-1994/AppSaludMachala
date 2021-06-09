package com.pulloquinga.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
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

}