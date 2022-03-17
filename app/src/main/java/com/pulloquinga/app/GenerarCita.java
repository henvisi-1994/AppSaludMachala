package com.pulloquinga.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private TextView emptyView;


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
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        recycler.setTextAlignment(RecyclerView.TEXT_ALIGNMENT_CENTER);
        emptyView = (TextView) findViewById(R.id.empty_view);
        InizializaDati();
    }
    public void filtrar(String fecha) {
        ArrayList<Horario> filtrarLista = new ArrayList<>();
        for(Horario horario : horarios) {
            if(horario.getFecha().compareTo(fecha)==0&&horario.getId_medico()==medico.getId_medico()) {
                filtrarLista.add(horario);
            }
        }
        if (filtrarLista.isEmpty()) {
            recycler.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
        else {
            recycler.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
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
                int dia=dayOfMonth;
                int mes=monthOfYear+1;
                String diaactual,mesactual;
                if(dia>=10){
                    diaactual=String.valueOf(dayOfMonth);
                }
                else{
                    diaactual="0"+String.valueOf(dayOfMonth);
                }
                if(mes>=10){
                    mesactual=String.valueOf(mes);
                }
                else{
                    mesactual="0"+String.valueOf(mes);
                }
                String fecha_filtro=year+"-"+(mesactual)+"-"+diaactual;
                String fecha = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                efecha.setText(fecha);
                Log.d("Formato Fecha",fecha_filtro);
                filtrar(fecha_filtro);
            }
        }
                ,ano,mes,dia);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
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
                int mes=c.get(Calendar.MONTH)+1;
                int ano=c.get(Calendar.YEAR);
                String diaactual;
                String mesactual;

                if(dia>=10){
                    diaactual=String.valueOf(dia);
                }
                else{
                    diaactual="0"+String.valueOf(dia);
                }
                if(mes>=10){
                    mesactual=String.valueOf(mes);
                }
                else{
                    mesactual="0"+String.valueOf(mes);
                }
                String fecha=ano+"-"+mesactual+"-"+diaactual;
                String fechaactual=diaactual+"/"+mesactual+"/"+ano;
                efecha.setText(fechaactual);
                Log.d("Fecha Actual",fecha);
                if (response.isSuccessful()) {
                    horarios = (Recursos.listToArrayList(response.body()));
                    int id_centromedico = getIntent().getIntExtra("id_centromedico",0);
                    Log.d("CentroMedico", String.valueOf(id_centromedico));
                    if (horarios.isEmpty()) {
                        recycler.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                    else {
                        recycler.setVisibility(View.VISIBLE);
                        emptyView.setVisibility(View.GONE);
                    }
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