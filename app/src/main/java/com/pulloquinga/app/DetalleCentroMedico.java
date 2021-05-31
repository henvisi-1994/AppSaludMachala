package com.pulloquinga.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetalleCentroMedico extends AppCompatActivity {
    private Button btnUbicacion;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btnUbicacion = findViewById(R.id.btnUbicacion);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_centro_medico);
       /* btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                startActivity(intent);
            }
        });*/

    }
    public void ubicacion(View view){
        url="https://goo.gl/maps/SY2yMDKCvxCzNKuF8";
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }
}