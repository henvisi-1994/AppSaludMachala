package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.Config.ConfigPagos;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;
import com.pulloquinga.app.models.RespuestaServer;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.paymentez.android.Paymentez;
import com.paymentez.android.view.CardMultilineWidget;
import com.pulloquinga.app.models.User;
import com.pulloquinga.app.models.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GestionPago extends AppCompatActivity {
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    public Medico medico;
    public Horario horario;
    public String token;
    public ArrayList<Card> tarjetas=new ArrayList();
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            setContentView(R.layout.activity_gestion_pago);
            medico = (Medico) getIntent().getSerializableExtra("medico");
            horario = (Horario) getIntent().getSerializableExtra("horario");
            token = getIntent().getStringExtra("token");
            recycler=(RecyclerView) findViewById(R.id.list_tarjetas);
            recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
            InizializaDati();

        }
        catch (Exception e){
            Log.d("Error",e.toString());

        }

    }
    public  void InizializaDati(){
        //noticias.add(new Noticia(1,"Titulo1","gdfgdfgdfgdf","sfsdfsdfsd"));
        try{
            SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            String identificacion = prefs.getString("identificacion", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String email = prefs.getString("email", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            User usuario=new User(identificacion,email);
            Log.d("IDENTIFICACION",identificacion);
            Call<List<Card>> listCall=servicio.obtener_tarjeta(identificacion);
        listCall.enqueue(new Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                if (response.isSuccessful()){
                    tarjetas=(Recursos.listToArrayList(response.body()));
                    AdapterCards adapter=new AdapterCards(tarjetas,medico,horario,usuario);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {
                Log.d("ERROR" ,t.getMessage());
            }
        });
        }
         catch (Exception e){
             Log.e("ERROR", e.toString());

          }


    }
    public void agregarCard(View view){
        Intent detalle = new Intent(this, AgregarTarjeta.class);
        this.startActivity(detalle);
    }

}