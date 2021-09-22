package com.pulloquinga.app;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenerarCita extends AppCompatActivity {
    private ApiService servicio = Config.getRetrofit().create(ApiService.class);
    ArrayList<Horario> horarios = new ArrayList();
    RecyclerView recycler;
    Medico medico = new Medico();
    AdapterHorarios adapter;
    private int dia,mes,ano;
    TextView efecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_cita);
        medico = (Medico) getIntent().getSerializableExtra("medico");
        TextView nombre_medico = (TextView) findViewById(R.id.txt_nom_medico);
        efecha = (TextView) findViewById(R.id.txt_fecha);
        nombre_medico.setText(medico.getNombre_medico());
        TextView especialidad = (TextView) findViewById(R.id.especialidad);
        especialidad.setText(medico.getNombre_especialidad());
        recycler = (RecyclerView) findViewById(R.id.list_horario);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        int spanCount = 2; // 3 columns
        int spacing = 30; // 50px
        boolean includeEdge = false;
        recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
    }
    public void filtrar(String fecha) {
        ArrayList<Horario> filtrarLista = new ArrayList<>();
        Log.d("Fecha",fecha);

        for(Horario horario : horarios) {
            if(horario.getFecha().compareTo(fecha)==0) {
                filtrarLista.add(horario);
            }
        }

        adapter.filtrar(filtrarLista);
    }
    public void asignar_fecha(View view){
        final Calendar c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);



        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String fecha_filtro=year+"-"+(monthOfYear + 1)+"-"+dayOfMonth;
                String fecha = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                efecha.setText(fecha);
                filtrar(fecha_filtro);
            }
        }
                ,ano,mes,dia);
        datePickerDialog.show();
    }

    private void InizializaDati() {
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        //try{
        Call<List<Horario>> listCall = servicio.getHorarios();
        listCall.enqueue(new Callback<List<Horario>>() {

            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                final Calendar c= Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes=c.get(Calendar.MONTH);
                int ano=c.get(Calendar.YEAR);
                String fecha=ano+"-"+mes+"-"+dia;
                if (response.isSuccessful()) {
                    horarios = (Recursos.listToArrayList(response.body()));
                    int id_centromedico = getIntent().getIntExtra("id_centromedico",0);
                    Log.d("CentroMedico", String.valueOf(id_centromedico));
                    adapter= new AdapterHorarios(horarios,medico);
                    recycler.setAdapter(adapter);
                    filtrar(fecha);
                }

            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {

            }
        });

    }
}