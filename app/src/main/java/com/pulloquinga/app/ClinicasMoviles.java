package com.pulloquinga.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ClinicasMoviles extends AppCompatActivity {
    EditText editTextdescripcionclinica;
    EditText editTextdescripcioncm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicas_moviles);
        editTextdescripcionclinica=(EditText) findViewById(R.id.editTextdescripcionclinica);
        editTextdescripcioncm2=(EditText) findViewById(R.id.editTextdescripcioncm2);
        Recursos.texto_no_editable(editTextdescripcionclinica);
        Recursos.texto_no_editable(editTextdescripcioncm2);
    }



    public void enlaceclinicamoviles(View view){
        startActivity(Recursos.enlaces("https://saludmachala.gob.ec/wp-content/uploads/2021/05/MODELO-DE-SOLICITUD-DE-JORNADA-MEDICA.pdf"));
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