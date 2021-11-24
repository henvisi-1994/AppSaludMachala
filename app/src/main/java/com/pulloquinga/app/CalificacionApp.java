package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.CalificacionAppModel;
import com.pulloquinga.app.models.CentroMedico;
import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.RequireCalificacion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalificacionApp extends AppCompatActivity {
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    public CalificacionAppModel calap;
    EditText txtmcomen;
    int id_cita;
    TextView txt_calificacion;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion_app);
        txtmcomen=(EditText)findViewById(R.id.txtmcomen);
        txt_calificacion=(TextView) findViewById(R.id.txtcalificacion);
        id_cita= getIntent().getIntExtra("id_cita",0);
        calap=new CalificacionAppModel();
        calap.setIdCita(id_cita);
    }
    public void bueno(View view){
        calap.setCalificacion("Bueno");
        txt_calificacion.setText(calap.getCalificacion());
    }
    public void regular(View view){
        calap.setCalificacion("Regular");
        txt_calificacion.setText(calap.getCalificacion());
    }
    public void malo(View view){
        calap.setCalificacion("Malo");
        txt_calificacion.setText(calap.getCalificacion());
    }
    public void enviar_calificacion(View view){
        context=view.getContext();
        calap.setComentario(txtmcomen.getText().toString());
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        Call<RequireCalificacion> call = servicio.calificar_app(token,calap);
        call.enqueue(new Callback<RequireCalificacion>() {
            @Override
            public void onResponse(Call<RequireCalificacion> call, Response<RequireCalificacion> response) {
                try{
                    Toast.makeText(getApplicationContext(), "Gracias por usar nuestro Servicio, Su opinión es importante.", Toast.LENGTH_LONG).show();
                    Intent sc = new Intent(context, SubmenuCita.class);
                    startActivity(sc);

                }catch(Exception e){
                    Log.d("Errorrrrr",e.toString());
                }
            }

            @Override
            public void onFailure(Call<RequireCalificacion> call, Throwable t) {
                Log.d("Errorrrrr",t.toString());
            }
        });
    }
}