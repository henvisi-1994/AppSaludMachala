package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.TokenPago;
import com.pulloquinga.app.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComprobarCita extends AppCompatActivity {
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    public Medico medico;
    public Horario horario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprobar_cita);
        TextView txt_nom_especialidad = (TextView) findViewById(R.id.txt_nom_especialidad);
        TextView txt_nom_medico=(TextView) findViewById(R.id.txt_nom_medico);
        TextView txt_fecha=(TextView) findViewById(R.id.txt_fecha);
        TextView txt_hora=(TextView) findViewById(R.id.txt_hora);
        TextView txt_valor=(TextView) findViewById(R.id.txt_Valor);
        TextView txt_centroM=(TextView) findViewById(R.id.txt_centroM);
         medico = (Medico) getIntent().getSerializableExtra("medico");
         horario = (Horario) getIntent().getSerializableExtra("horario");
        txt_nom_especialidad.setText(medico.getNombre_especialidad());
        txt_nom_medico.setText(medico.getNombre_medico());
        txt_fecha.setText(horario.getFecha());
        txt_hora.setText(horario.getHora());
        txt_centroM.setText(medico.getNombre_centroMedico());
        txt_valor.setText("$ "+String.valueOf(5.50));

    }
    public  void InizializaDati() {
        try {
            Call<TokenPago> listCall = servicio.getTokenPago();
            listCall.enqueue(new Callback<TokenPago>() {
                @Override
                public void onResponse(Call<TokenPago> call, Response<TokenPago> response) {
                    Log.d("tokennnPAGO",response.body().toString());
                }

                @Override
                public void onFailure(Call<TokenPago> call, Throwable t) {

                }
            });

        }catch (Exception e){
            Log.d("Error",e.toString());
        }
    }
    public void gestionPago(View view){
        InizializaDati();
        Intent gp = new Intent(this, GestionPago.class);
        gp.putExtra("medico", medico);
        gp.putExtra("horario", horario);
        startActivity(gp);
    }
}