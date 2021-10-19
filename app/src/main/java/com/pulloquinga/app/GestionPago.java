package com.pulloquinga.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.RespuestaServer;
import com.squareup.picasso.Picasso;


import androidx.appcompat.app.AppCompatActivity;

import com.paymentez.android.Paymentez;
import com.paymentez.android.model.Card;
import com.paymentez.android.rest.TokenCallback;
import com.paymentez.android.rest.model.PaymentezError;
import com.paymentez.android.view.CardMultilineWidget;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GestionPago extends AppCompatActivity {
    public CardMultilineWidget cw;
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    public Medico medico;
    public Horario horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            setContentView(R.layout.activity_gestion_pago);
            medico = (Medico) getIntent().getSerializableExtra("medico");
            horario = (Horario) getIntent().getSerializableExtra("horario");
        /*Card tarjeta=new Card();
        tarjeta.setNumber("4111111111111111");
        tarjeta.setHolderName("RevolutionTech");
        tarjeta.setExpiryMonth(01);
        tarjeta.setExpiryYear(23);
        tarjeta.setCVC("634");*/
            /**
             * Init library
             *number: número de tarjeta como una cadena sin separadores, por ejemplo, '4242424242424242'.
             * holderName: nombre del titular de la tarjeta.
             * expMonth: número entero que representa el mes de vencimiento de la tarjeta, por ejemplo, 12.
             * expYear: número entero que representa el año de vencimiento de la tarjeta, por ejemplo, 2013.
             * cvc: código de seguridad de la tarjeta como una cadena, por ejemplo, '123'.
             * escribe:
             * @param test_mode false to use production environment
             * @param paymentez_client_app_code provided by Paymentez.
             * @param paymentez_client_app_key provided by Paymentez.
             */
            boolean test_mode=true;
            String paymentez_client_app_code="TPP3-EC";
            String paymentez_client_app_key="ZfapAKOk4QFXheRNvndVib9XU3szzg";
            //Paymentez.setEnvironment(test_mode, "AbiColApp",paymentez_client_app_key );
            Paymentez.setEnvironment(test_mode, paymentez_client_app_code,paymentez_client_app_key );
            cw=(CardMultilineWidget)findViewById(R.id.card_pago);

        }
        catch (Exception e){
            Log.d("Error",e.toString());

        }

    }
    public void guardar(View view) {
        try{
            SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String user = prefs.getString("user", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            Cita cita=new Cita(medico.getId_especialidad(),  horario.getId_horario(),  medico.getId_medico(),  user);
            Call<Cita> call = servicio.registro_cita(token,cita);
            call.enqueue(new Callback<Cita>() {
                @Override
                public void onResponse(Call<Cita> call, Response<Cita> response) {
                    Toast.makeText(getApplicationContext(), "Se ha creado la cita exitosamente ", Toast.LENGTH_LONG).show();
                    borrar_horario();
                }

                @Override
                public void onFailure(Call<Cita> call, Throwable t) {
                Log.d("Errorrrrr",t.toString());
                }
            });
            /*Card cardToSave=cw.getCard();

            Paymentez.addCard(this, "0705332989", "frankwilliams2905@gmail.com", cardToSave, new TokenCallback() {

                public void onSuccess(Card card) {

                    if(card != null){
                        if(card.getStatus().equals("valid")){
                            Log.d("Card Successfully Added","status: " + card.getStatus() + "\n" +
                                    "Card Token: " + card.getToken() + "\n" +
                                    "transaction_reference: " + card.getTransactionReference());
                            Toast.makeText(getApplicationContext(), "Card Successfully Added"+"status: " + card.getStatus() + "\n" +
                                    "Card Token: " + card.getToken() + "\n" +
                                    "transaction_reference: " + card.getTransactionReference(), Toast.LENGTH_LONG).show();

                        } else if (card.getStatus().equals("review")) {
                            Log.d("Card Under Review","status: " + card.getStatus() + "\n" +
                                    "Card Token: " + card.getToken() + "\n" +
                                    "transaction_reference: " + card.getTransactionReference());
                            Toast.makeText(getApplicationContext(), "Card Under Review" + "status: " + card.getStatus() + "\n" +
                                    "Card Token: " + card.getToken() + "\n" +
                                    "transaction_reference: " + card.getTransactionReference(),Toast.LENGTH_LONG).show();

                        } else {
                            Log.d("Error","status: " + card.getStatus() + "\n" +
                                    "message: " + card.getMessage());
                            Toast.makeText(getApplicationContext(), "Error" +"status: " + card.getStatus() + "\n" +
                                    "message: " + card.getMessage(),Toast.LENGTH_LONG).show() ;
                        }


                    }

                    //TODO: Create charge or Save Token to your backend
                }

                public void onError(PaymentezError error) {
                    Log.d("Error","status: " + "Type: " + error.getType() + "\n" +
                            "Help: " + error.getHelp() + "\n" +
                            "Description: " + error.getDescription());
                    Toast.makeText(getApplicationContext(), "Error" +"status: " + "Type: " + error.getType() + "\n" +
                            "Help: " + error.getHelp() + "\n" +
                            "Description: " + error.getDescription(),Toast.LENGTH_LONG).show() ;
                    //TODO: Handle error
                }

            });*/
        }
        catch (Exception e){
            Log.d("Error Guardar",e.toString());

        }

    }
    public void borrar_horario(){
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        Log.d("HORARIOGESTIONPAGO",String.valueOf(horario.getId_horario()));
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
}