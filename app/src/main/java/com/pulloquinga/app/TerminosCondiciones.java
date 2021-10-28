package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.Toast;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Noticia;
import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.Usuario;
import com.pulloquinga.app.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerminosCondiciones extends AppCompatActivity {
WebView wv;
CheckBox cb;
Usuario usuario;
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_condiciones);
        wv=(WebView)findViewById(R.id.termi_cond);
        wv.loadUrl("https://apiapp.saludmachala.gob.ec/terminosycondiciones");
        cb=(CheckBox)findViewById(R.id.cbaceptar);
        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

    }
    public void loguearCheckbox(View v) {
        if(cb.isChecked()){
            Call<RespuestaServer> call = servicio.registro(usuario);
            call.enqueue(new Callback<RespuestaServer>() {
                @Override
                public void onResponse(Call<RespuestaServer> call, Response<RespuestaServer> response) {
                    try{
                        String respuesta = response.message();
                        switch (respuesta){
                            case "OK":
                                ingresar();
                                break;
                            case "Bad Request":
                                Toast.makeText(v.getContext(), "Email Repetido", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }catch (Exception e){
                        Log.d("Error",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<RespuestaServer> call, Throwable t) {
                    Log.d("Error al registrar",call.toString());
                }
            });

        }
        else{
            Toast.makeText(this, "Acepte Terminos y Condiciones", Toast.LENGTH_LONG).show();
        }
    }
    public void ingresar() {
        Intent loguin = new Intent(this, LoginActivity.class);
        startActivity(loguin);
    }
}