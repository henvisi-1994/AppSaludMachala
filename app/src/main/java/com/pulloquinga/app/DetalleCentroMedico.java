package com.pulloquinga.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.CentroMedico;

import java.util.ArrayList;

public class DetalleCentroMedico extends AppCompatActivity {
    TextView txvnombre,txvtelefono,txvdireccion;
    ArrayList<String> especialidades=new ArrayList();
    RecyclerView recycler;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_centro_medico);
        CentroMedico centromedico= (CentroMedico) getIntent().getSerializableExtra("centromedico");
        recycler=(RecyclerView) findViewById(R.id.recyclerId);
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        recycler.setLayoutManager(new GridLayoutManager(this,2));
            int spanCount = 2; // 3 columns
            int spacing = 30; // 50px
            boolean includeEdge = false;
            recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
            txvnombre = (TextView)findViewById(R.id.txvnombre);
        txvtelefono = (TextView)findViewById(R.id.txvtelefono);
        txvdireccion = (TextView)findViewById(R.id.txvdireccion);
            txvnombre.setText(centromedico.getNombre());
            txvtelefono.setText(centromedico.getTelefono());
            txvdireccion.setText(centromedico.getDireccion());
            url=centromedico.getUbicacion();
            String[] aux = centromedico.getEspecialidades().split(",", 13);
            for (int i=0;i<=(aux.length-1);i++){
                especialidades.add(aux[i]);
            }
            AdapterEspecialidades adapter=new AdapterEspecialidades(especialidades);
            recycler.setAdapter(adapter);

        }
        catch (Exception e)
        {
            Log.e("error", e.toString());
            Toast toast = Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void ubicacion(View view){
        startActivity(Recursos.enlaces(url));

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