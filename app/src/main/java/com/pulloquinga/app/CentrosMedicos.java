package com.pulloquinga.app;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pulloquinga.app.models.CentroMedico;

import java.util.ArrayList;

public class CentrosMedicos extends AppCompatActivity {
    ArrayList<CentroMedico> centrosmedicos = new ArrayList();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_medicos);
        recycler=(RecyclerView) findViewById(R.id.recycler_cm);
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        int spanCount = 2; // 3 columns
        int spacing = 50; // 50px
        boolean includeEdge = false;
        recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
        AdapterCentrosMedicos adapter=new AdapterCentrosMedicos(centrosmedicos);
        recycler.setAdapter(adapter);
    }
    public  void InizializaDati(){
        centrosmedicos.add(new CentroMedico(1,"U.M.M. Dr. Pomerio Cabrera","■ Medicina General,■ Obstetricia,■ Odontología,■ Psicología,■ Medico Cirujano,■ Ginecología,■ Hospitalización,■ Partos,■ Nebulizaciones,■ Laboratorio,■ Farmacia,■ Enfermeria,■ Medicina General(Medicos Residentes)","Barrio 4 de Abril","(07)2927200 / (07)2927201","https://goo.gl/maps/LhQwcLiFNsLtJ1bn9"));
        centrosmedicos.add(new CentroMedico(2,"U.M.M. Del Sur","■ Medicina General,■ Obstetricia,■ Odontología,■ Psicologo Clínico,■ Farmacia,■ Psicología,■ Laboratorio,■ Enfermería,■ Terapia Respiratoria)","Barrio Luz de América","(07)2794030","https://goo.gl/maps/5gCrp38qwch4fXhTA"));
        centrosmedicos.add(new CentroMedico(3,"C.M.M. Dr. Marco Espinoza","■ Medicina General,■ Odontología,■ Enfermería,■ Laboratorio,■ Farmacia,■ Teraìa Respiratoria)","Barrio González Rubio","(07)2929813","https://goo.gl/maps/UmuABoLjdUiFi7HZA"));
        centrosmedicos.add(new CentroMedico(4,"C.M.M. 25 de Diciembre","■ Medicina General,■ Obstetricia,■ Odontología,■ Laboratorio,■ Farmacia,■ Terapia Respiratoria,■ Enfermería","Cdla. 25 de Diciembre"," ","https://goo.gl/maps/Po3i9cmYDeZkGWyp8"));
        centrosmedicos.add(new CentroMedico(5,"C.M.M. Manuel Pozo","■ Medicina General,■ Obstetricia,■ Odontología,■ Laboratorio,■ Farmacia,■ Terapia Respiratoria,■ Enfermería","Cdla. Los Vergeles","(07)2185248","https://goo.gl/maps/G8sExb1Sbjs4Vwfy5"));
        centrosmedicos.add(new CentroMedico(6,"C.M.M. Federico Páez","■ Medicina General,■ Odontología,■ Enfermería,■ Laboratorio,■ Farmacia,■ Terapia Respiratoria","Barrio Federico Páez","(07)2130494","https://goo.gl/maps/8gzZQFbCmDUJed7V8"));
        centrosmedicos.add(new CentroMedico(7,"C.M.M. 8 de Noviembre","■ Medicina General,■ Obstetricia,■ Odontología,■ Laboratorio,■ Farmacia,■ Terapia Respiratoria,■ Enfermería)","Cdla. 8 de Noviembre","(07)2960073","https://goo.gl/maps/1eVguroeLUKv1ig6A"));
        centrosmedicos.add(new CentroMedico(8,"C.M.M. Dr. Rómulo Cedillo","■ Medicina General,■ Obstetricia,■ Odontología,■ Psicología,■ Laboratorio,■ Farmacia,■ Terapia Respiratoria,■ Enfermeía","Parroquia El cambio","(07)2992645","https://goo.gl/maps/icL3JPAJmBK23URAA"));
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