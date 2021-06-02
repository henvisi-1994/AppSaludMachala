package com.pulloquinga.app;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.transform.sax.SAXSource;

public class DetalleCentroMedico extends AppCompatActivity {
    TextView txvnombre,txvtelefono,txvdireccion;
    ArrayList<CentroMedico> CentrosMedicos = new ArrayList();
    ArrayList<String> especialidades=new ArrayList();
    RecyclerView recycler;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_centro_medico);
        int id=getIntent().getExtras().getInt("id");
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
        InizializaDati();
        CentroMedico centromedico=BuscarCentroMedico(id);
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

    public  void InizializaDati(){
        CentrosMedicos.add(new CentroMedico(1,"U.M.M. Dr. Pomerio Cabrera","■ Medicina General,■ Obstetricia,■ Odontología,■ Psicología,■ Medico Cirujano,■ Ginecología,■ Hospitalización,■ Partos,■ Nebulizaciones,■ Laboratorio,■ Farmacia,■ Enfermeria,■ Medicina General(Medicos Residentes)","Barrio 4 de Abril","(07)2927200 / (07)2927201","https://goo.gl/maps/LhQwcLiFNsLtJ1bn9"));
    }
    public  CentroMedico BuscarCentroMedico(int id) {
        CentroMedico resultado = null;
        for (CentroMedico centromedico : CentrosMedicos) {
            if (centromedico.getId()==id) {
                resultado = centromedico;
                break;
            }
        }
        return resultado;
    }
    public void ubicacion(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }
}