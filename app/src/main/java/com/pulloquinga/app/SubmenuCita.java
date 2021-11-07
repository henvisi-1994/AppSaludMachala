package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmenuCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_cita);
    }
    public void generar_cita(View view){
        Intent citas_principal = new Intent(this, CitasPrincipal.class);
        startActivity(citas_principal);

    }
    public void historial_cita(View view){
        Intent hc = new Intent(this, HistorialCitas.class);
        startActivity(hc);

    }
    public void perfil_usuario(View view){
        Intent perfil = new Intent(this, PerfilUsuario.class);
        startActivity(perfil);

    }
}