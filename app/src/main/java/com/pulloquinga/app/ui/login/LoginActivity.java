package com.pulloquinga.app.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pulloquinga.app.CitasPrincipal;
import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.R;
import com.pulloquinga.app.Recursos;
import com.pulloquinga.app.RegistroUsuario;
import com.pulloquinga.app.SubmenuCita;
import com.pulloquinga.app.databinding.ActivityLoginBinding;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.RespuestaLoguin;
import com.pulloquinga.app.models.Usuario;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;
    private EditText email;
    private EditText password;
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;
        email = usernameEditText;
        password = passwordEditText;
        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }
    public void olvide_password(View view){
        startActivity(Recursos.enlaces("https://apiapp.saludmachala.gob.ec/password/reset"));
    }

    private void updateUiWithUser(LoggedInUserView model) {
        // TODO : Ingresar a pantalla principal de citas
        Usuario usuario = new Usuario(email.getText().toString(),password.getText().toString()) ;
        Call<RespuestaLoguin> call = servicio.loggearse(usuario);
        call.enqueue(new Callback<RespuestaLoguin>() {
            @Override
            public void onResponse(Call<RespuestaLoguin> call, Response<RespuestaLoguin> response) {
                try{
                    String respuesta = response.message();
                    switch (respuesta){
                        case "OK":
                            String welcome = getString(R.string.welcome);
                            if(response.body().getEmailVerifiedAt()==null){
                                Toast.makeText(getApplicationContext(), "Realice la verificación de su Cuenta a través del Correo Electrónico", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
                                ingresar();
                                SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("token", response.body().getAccess_token());
                                editor.putString("user", response.body().getUser());
                                editor.putString("email", response.body().getEmail());
                                editor.putString("identificacion", response.body().getIdentificacion());
                                editor.putString("telefono", response.body().getTelefono());
                                editor.putString("direccion", response.body().getDireccion());
                                editor.putString("clave", response.body().getClave());
                                editor.putInt("usuario_id", response.body().getId());
                                Log.d("TOKEN",response.body().getAccess_token());
                                editor.commit();
                            }
                            break;
                        case "Unauthorized":
                            Toast.makeText(getApplicationContext(), "Email o contraseña incorrectos", Toast.LENGTH_LONG).show();
                            break;
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Realice la verificación de su Cuenta a través del Correo Electrónico", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RespuestaLoguin> call, Throwable t) {
                Log.d("Error Login: ",call.toString());
                String welcome = "NO se pudo Iniciar sesion";
                Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
            }

        });


    }
    public void ingresar() {
        Intent submenu_citas = new Intent(this, SubmenuCita.class);
        startActivity(submenu_citas);
    }
    public  void Registro(View view){
        Intent registro = new Intent(this, RegistroUsuario.class);
        startActivity(registro);
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}