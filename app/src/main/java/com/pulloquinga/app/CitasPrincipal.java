package com.pulloquinga.app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.CentroMedico;

import java.util.ArrayList;

public class CitasPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recycler;
        ArrayList<String> tipo_medico=new ArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_principal);


    }
    public void medico_red(View view){
        Intent detalle = new Intent(this, ListCentrosMedicosDB.class);
        detalle.putExtra("tipo_medico", "Medico Fijo");
        this.startActivity(detalle);
    }
    public void medico_produccion(View view){
        Intent detalle = new Intent(this, list_especialidades_db.class);
        detalle.putExtra("tipo_medico", "Medico Produccion");
        this.startActivity(detalle);

    }
}
