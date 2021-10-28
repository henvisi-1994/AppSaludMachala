package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.Config.ConfigPagos;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.Email;
import com.pulloquinga.app.models.EmailComprobante;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.OUC;
import com.pulloquinga.app.models.Order;
import com.pulloquinga.app.models.RequestOUC;
import com.pulloquinga.app.models.RequireEmail;
import com.pulloquinga.app.models.RequireEmailComprobante;
import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.TokenPago;
import com.pulloquinga.app.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pago extends AppCompatActivity {
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    private ApiService servicio_pago= ConfigPagos.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);

    public User user;
public Card card;
public Order order;
public OUC ouc;
public Medico medico;
public Horario horario;
TextView txt_ci,txt_nomb,txt_email,txt_desc,txt_nrefer;
String smail,spassword;
TextView txt_precio;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String email = prefs.getString("email", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        String identificacion = prefs.getString("identificacion", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        card = (Card) getIntent().getSerializableExtra("card");
        medico = (Medico) getIntent().getSerializableExtra("medico");
        horario = (Horario) getIntent().getSerializableExtra("horario");
        user=new User(identificacion,email);
        double amount=medico.getValor();
        String description="Reserva de cita médica a través de Red de Salud con el Doctor "+medico.getNombre_medico()
                +" en la especialidad de "+medico.getNombre_especialidad()+" en el centro medico "+medico.getNombre_centroMedico();
        String dev_reference="C-001";
        smail="reservas.ap@saludmachala.gob.ec";
                spassword="AppSalud2021**";
        double tax_percentage=0.0;
        double taxable_amount=amount;
        double vat=0.0;
        order=new Order(amount,tax_percentage,taxable_amount,description,dev_reference,vat);
        ouc=new OUC(user,order,card);
        txt_nomb=(TextView)findViewById(R.id.txt_nomb);
        txt_ci=(TextView)findViewById(R.id.txt_ci);
        txt_email=(TextView)findViewById(R.id.txt_email);
        txt_desc=(TextView)findViewById(R.id.txt_desc);
        txt_nrefer=(TextView)findViewById(R.id.txt_nrefer);
        txt_precio=(TextView)findViewById(R.id.txt_precio);
        txt_nomb.setText(card.getHolderName());
        txt_ci.setText(user.getId());
        txt_email.setText(user.getEmail());
        txt_desc.setText(order.getDescription());
        txt_nrefer.setText(order.getDev_reference());
        txt_precio.setText("$"+String.valueOf(order.getAmount()));



    }
    public void pagar(View view){
        context=view.getContext();
        Call<TokenPago> listCall = servicio.getTokenPago();
        listCall.enqueue(new Callback<TokenPago>() {
            @Override
            public void onResponse(Call<TokenPago> call, Response<TokenPago> response) {
                realizar_pago(response.body().getAuthtoken());
            }

            @Override
            public void onFailure(Call<TokenPago> call, Throwable t) {

            }
        });

    }
    public void borrar_horario(){
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        //Log.d("HORARIOGESTIONPAGO",String.valueOf(horario.getId_horario()));
        Call<RespuestaServer> call = servicio.eliminar_horario(token,horario.getId_horario());
        call.enqueue(new Callback<RespuestaServer>() {
            @Override
            public void onResponse(Call<RespuestaServer> call, Response<RespuestaServer> response) {
            }

            @Override
            public void onFailure(Call<RespuestaServer> call, Throwable t) {
                Log.d("Error al eliminar",call.toString());

            }
        });
    }
    public void realizar_pago(String token){
        Call<RequestOUC> call = servicio_pago.generar_pago(token,ouc);
        call.enqueue(new Callback<RequestOUC>() {
            @Override
            public void onResponse(Call<RequestOUC> call, Response<RequestOUC> response) {
                Toast.makeText(getApplicationContext(), response.body().getTransaction().getMessage(), Toast.LENGTH_LONG).show();
                Log.d("PAGOO",response.body().getTransaction().getMessage());
                generar_cita();
                enviar_email();
                enviar_comprobante(response.body().getTransaction().getAmount(),response.body().getTransaction().getId());
            }
            @Override
            public void onFailure(Call<RequestOUC> call, Throwable t) {
                Log.d("Errorrrrr",t.toString());
            }
        });
    }
    public void enviar_email(){
        try{
            SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String user = prefs.getString("user", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            Email email=new Email(medico.getNombre_especialidad(),  medico.getNombre_centroMedico(),  medico.getNombre_medico(),  medico.getId_medico(),  user,medico.getId_centroMedico());
            Call<RequireEmail> call = servicio.enviar_email(token,email);
            call.enqueue(new Callback<RequireEmail>() {
                @Override
                public void onResponse(Call<RequireEmail> call, Response<RequireEmail> response) {
                    try{
                        Log.d("EMAIL",response.body().toString());
                    }catch(Exception e){
                        Log.d("Errorrrrr",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<RequireEmail> call, Throwable t) {
                    Log.d("Errorrrrr",t.toString());
                }
            });
        }
        catch (Exception e){
            Log.d("Error Guardar",e.toString());

        }
    }
    public void enviar_comprobante(double precio,String identificacion){
        try{
            SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String user = prefs.getString("user", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String dni = prefs.getString("identificacion", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String email_user = prefs.getString("email", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            //Email email=new Email(medico.getNombre_especialidad(),  medico.getNombre_centroMedico(),  medico.getNombre_medico(),  medico.getId_medico(),  user,medico.getId_centroMedico());
            EmailComprobante email=new EmailComprobante(medico.getNombre_especialidad(), email_user, medico.getNombre_medico(), dni, user, identificacion,  precio);
            Call<RequireEmailComprobante> call = servicio.enviar_comprobante(token,email);
            call.enqueue(new Callback<RequireEmailComprobante>() {
                @Override
                public void onResponse(Call<RequireEmailComprobante> call, Response<RequireEmailComprobante> response) {
                    try{
                        Log.d("EMAIL",response.body().toString());
                    }catch(Exception e){
                        Log.d("Errorrrrr",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<RequireEmailComprobante> call, Throwable t) {
                    Log.d("Errorrrrr",t.toString());
                }
            });
        }
        catch (Exception e){
            Log.d("Error Guardar",e.toString());

        }
    }



    private void generar_cita() {
        try{
            SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String user = prefs.getString("user", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            Cita cita=new Cita(medico.getId_especialidad(),  horario.getId_horario(),  medico.getId_medico(),  user);
            Call<Cita> call = servicio.registro_cita(token,cita);
            call.enqueue(new Callback<Cita>() {
                @Override
                public void onResponse(Call<Cita> call, Response<Cita> response) {
                    try{
                        Toast.makeText(getApplicationContext(), "Se ha creado la cita exitosamente ", Toast.LENGTH_LONG).show();
                        Log.d("CITA",response.body().toString());
                        borrar_horario();
                        Intent inicio = new Intent(context, MainActivity.class);
                        startActivity(inicio);

                    }catch(Exception e){
                        Log.d("Errorrrrr",e.toString());
                    }
                }

                @Override
                public void onFailure(Call<Cita> call, Throwable t) {
                    Log.d("Errorrrrr",t.toString());
                }
            });
        }
        catch (Exception e){
            Log.d("Error Guardar",e.toString());

        }
    }
}