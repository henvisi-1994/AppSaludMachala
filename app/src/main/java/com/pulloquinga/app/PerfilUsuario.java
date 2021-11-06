package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.Usuario;
import com.pulloquinga.app.ui.login.LoginActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import com.android.volley.Response;

public class PerfilUsuario extends AppCompatActivity {
    EditText nomb_suaurio;
    EditText emailpu;
    EditText identifica;
    EditText telef;
    EditText direcc;
    EditText key;
    LinearLayout password;
int id;
String token;
CheckBox cambcont;
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String user = prefs.getString("user", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        String email = prefs.getString("email", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        String identificacion = prefs.getString("identificacion", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        String telefono = prefs.getString("telefono", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        String direccion = prefs.getString("direccion", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        String clave = prefs.getString("clave", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        id = prefs.getInt("usuario_id", 0); // prefs.getString("nombre del campo" , "valor por defecto")
        Log.d("ID",String.valueOf(id));
        token = prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        Usuario usuario=new Usuario(user,email,clave,telefono,identificacion,direccion);
        nomb_suaurio=(EditText) findViewById(R.id.txt_nomb_usuario);
        emailpu=(EditText) findViewById(R.id.txt_emailu);
        identifica=(EditText) findViewById(R.id.txt_identificacon);
        telef=(EditText) findViewById(R.id.txt_telef);
        direcc=(EditText) findViewById(R.id.txt_direcc);
        key=(EditText) findViewById(R.id.txt_pass);
        nomb_suaurio.setText(usuario.getName());
        emailpu.setText(usuario.getEmail());
        identifica.setText(usuario.getIdentificacion());
        telef.setText(usuario.getTelefono());
        direcc.setText(usuario.getDireccion());
        password=(LinearLayout)findViewById(R.id.password);
        cambcont=(CheckBox) findViewById(R.id.checkcc);
    }
    public void guardar(View view){
        try{
            Usuario usuariog=new Usuario(nomb_suaurio.getText().toString(),emailpu.getText().toString(),key.getText().toString(),telef.getText().toString(),identifica.getText().toString(),direcc.getText().toString(),id,"L@GH#h2zqG*B");
            Call<RespuestaServer> listCall=servicio.update_usuario(token,usuariog);
            //Call<RespuestaServer> listCall=servicio.registro(usuariog);
            listCall.enqueue(new Callback<RespuestaServer>() {
                @Override
                public void onResponse(Call<RespuestaServer> call, Response<RespuestaServer> response) {
                    try{
                        String respuesta = response.message();
                        switch (respuesta){
                            case "OK":
                                Toast.makeText(view.getContext(), "Usuario actualizado", Toast.LENGTH_LONG).show();
                                if(usuariog.getPassword().isEmpty()){
                                    principal();

                                }
                                else{
                                    loguin();
                                }
                                break;
                        }
                    }catch (Exception e){
                        Log.d("Error",e.toString());
                    }
                }
                @Override
                public void onFailure(Call<RespuestaServer> call, Throwable t) {
                    Log.d("ERROR" ,t.getMessage());
                }
            });
        }catch (Exception e){
            Log.d("ERROR ",e.toString());
        }

    }
    public void mostrar()
    {
        if (password.getVisibility() == View.GONE)
        {
            password.setVisibility(View.VISIBLE);
        }
    }

    public void ocultar()
    {
        if (password.getVisibility() == View.VISIBLE)
        {
            password.setVisibility(View.GONE);
        }

    }
    public void cambiarclave(View v){
        if(cambcont.isChecked()){
            mostrar();
        }else{
            ocultar();
        }
    }
    public void principal(){
        Intent mp = new Intent(this, SubmenuCita.class);
        startActivity(mp);

    }
    public void loguin(){
        Intent lg = new Intent(this, LoginActivity.class);
        startActivity(lg);
    }

}
