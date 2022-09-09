package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ProgressBar;
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
ProgressBar pb;

    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_condiciones);
        wv=(WebView)findViewById(R.id.termi_cond);

        wv.setWebViewClient(new WebViewClient() {


            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                String message = "SSL Certificate error.";
                switch (error.getPrimaryError()) {
                    case SslError.SSL_UNTRUSTED:
                        message = "The certificate authority is not trusted.";
                        break;
                    case SslError.SSL_EXPIRED:
                        message = "The certificate has expired.";
                        break;
                    case SslError.SSL_IDMISMATCH:
                        message = "The certificate Hostname mismatch.";
                        break;
                    case SslError.SSL_NOTYETVALID:
                        message = "The certificate is not yet valid.";
                        break;
                }
                message += "\"SSL Certificate Error\" Do you want to continue anyway?.. YES";

                handler.proceed();
            }

        });


        wv.loadUrl("https://apiapp.saludmachala.gob.ec/terminosycondiciones");
        cb=(CheckBox)findViewById(R.id.cbaceptar);
        usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        pb=(ProgressBar)findViewById(R.id.progressBar);
        this.visible(false);

    }
    public void loguearCheckbox(View v) {
        visible(true);
        if(cb.isChecked()){
            Call<RespuestaServer> call = servicio.registro(usuario);
            call.enqueue(new Callback<RespuestaServer>() {
                @Override
                public void onResponse(Call<RespuestaServer> call, Response<RespuestaServer> response) {
                    try{
                        String respuesta = response.message();
                        switch (respuesta){
                            case "OK":
                                visible(false);
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
    public void visible(boolean visibilidad){
        if (visibilidad) {
            pb.setVisibility(View.VISIBLE);
        }
        else {
            pb.setVisibility(View.GONE);
        }
    }
    public void ingresar() {
        Intent loguin = new Intent(this, LoginActivity.class);
        startActivity(loguin);
    }
}