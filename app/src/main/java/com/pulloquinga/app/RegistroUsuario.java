package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.Usuario;
import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Usuario;
import com.pulloquinga.app.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RegistroUsuario extends AppCompatActivity {
    private EditText name ;
    private EditText email;
    private EditText telefono;
    private EditText identificacion;
    private EditText direccion;
    private EditText password;
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        name = (EditText) findViewById(R.id.txtNombre);
        email = (EditText) findViewById(R.id.txtEmail);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        identificacion = (EditText) findViewById(R.id.txtIdentificacion);
        direccion = (EditText) findViewById(R.id.txtDireccion);
        password = (EditText) findViewById(R.id.txtpassword);
        validar();
    }
    public void Registrar(View view){
        Usuario usuario = new Usuario(name.getText().toString(),email.getText().toString(),password.getText().toString(),telefono.getText().toString(),identificacion.getText().toString(),direccion.getText().toString());
        if(validarEmail()&& ValidarVacio()&&validarIdentificacion()){
            Intent tc = new Intent(this, TerminosCondiciones.class);
            tc.putExtra("usuario",usuario);
            startActivity(tc);

        }else{
            Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_LONG).show();
        }

    }
    public boolean ValidarVacio(){
        boolean esValido=false;
        if(Recursos.Vacio(name)&&Recursos.Vacio(email)&&Recursos.Vacio(telefono)&&Recursos.Vacio(identificacion)&&
        Recursos.Vacio(direccion)&&Recursos.Vacio(password)){
            esValido=false;
        }
        else{
            esValido=true;
        }
        return esValido;
    }


    public void validar(){
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Editable",s.toString());
                if(Recursos.isNumeric(s.toString())){
                    name.setError("Ingrese Solo Letras");
                }
            }
        });
        telefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Editable",s.toString());
                if(!Recursos.isNumeric(s.toString())){
                    telefono.setError("Ingrese Solo Numeros");
                }

            }
        });
        identificacion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Editable",s.toString());
                if(!Recursos.isNumeric(s.toString())){
                    identificacion.setError("Ingrese Solo Numeros");
                }
            }
        });

    }
    public boolean validarIdentificacion(){
        boolean esValido=false;
        Log.d("Longitud Identifiacion",String.valueOf(identificacion.getText().length()));
        switch (identificacion.getText().length()){
            case 10:
                if(Recursos.isValidarCedula(identificacion.getText().toString())){
                    esValido=true;
                }
                else{
                    esValido=false;
                    identificacion.setError("Ingrese Cedula Valida");
                }
                break;
            case 13:
                if(Recursos.ValidarRUC(identificacion.getText().toString())){
                    esValido=true;
                }
                else{
                    esValido=false;
                    identificacion.setError("Ingrese RUC Valido");
                }
        }
        return esValido;
    }
    public boolean validarEmail(){
        boolean esValido=false;
        if(Recursos.isEmail(email.getText().toString())){
            esValido=true;
        }
        else{
            esValido=false;
            email.setError("Ingrese Email Valido");
        }
        return esValido;
    }


}
