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

import com.paymentez.android.Paymentez;
import com.paymentez.android.model.Card;
import com.paymentez.android.rest.TokenCallback;
import com.paymentez.android.rest.model.PaymentezError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class AgregarTarjeta extends AppCompatActivity {
    EditText editTextnombtitu,editTextnumcard,editTextfechacad,editTextcvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tarjeta);
        editTextnombtitu= (EditText) findViewById(R.id.editTextnombtitu);
        editTextnumcard= (EditText) findViewById(R.id.editTextnumcard);
        editTextfechacad= (EditText) findViewById(R.id.editTextfechacad);
        editTextcvc= (EditText) findViewById(R.id.editTextcvc);
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
        String paymentez_client_app_code="TPP3-EC-CLIENT";
        String paymentez_client_app_key="ZfapAKOk4QFXheRNvndVib9XU3szzg";
        //Paymentez.setEnvironment(test_mode, "AbiColApp",paymentez_client_app_key );
        Paymentez.setEnvironment(test_mode, paymentez_client_app_code,paymentez_client_app_key );

    }
    public void guardar(View view){
        try {
            String[] parts = editTextfechacad.getText().toString().split("/");
            Card cardToSave=new Card();
            //cardToSave.setNumber("4111111111111111");
            cardToSave.setNumber(editTextnumcard.getText().toString());

            cardToSave.setHolderName(editTextnombtitu.getText().toString());
            cardToSave.setExpiryMonth(Integer.parseInt(parts[0]));
            cardToSave.setExpiryYear(Integer.parseInt(parts[1]));
            cardToSave.setCVC(editTextcvc.getText().toString());
            //Card cardToSave=cw.getCard();
            SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            String email_user = prefs.getString("email", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            String dni = prefs.getString("identificacion", ""); // prefs.getString("nombre del campo" , "valor por defecto")
            if(validacion()){
                Paymentez.addCard(this, dni, email_user, cardToSave, new TokenCallback() {

                    public void onSuccess(Card card) {

                        if(card != null){
                            if(card.getStatus().equals("valid")){
                                Log.d("Card Successfully Added","status: " + card.getStatus() + "\n" +
                                        "Card Token: " + card.getToken() + "\n" +
                                        "transaction_reference: " + card.getTransactionReference());
                                Toast.makeText(getApplicationContext(), "Card Successfully Added"+"status: " + card.getStatus() + "\n" +
                                        "Card Token: " + card.getToken() + "\n" +
                                        "transaction_reference: " + card.getTransactionReference(), Toast.LENGTH_LONG).show();
                                Intent detalle = new Intent(view.getContext(), GestionPago.class);
                                view.getContext().startActivity(detalle);
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

                });

            }


        }catch (Exception e)
        {
            Log.d("Error Guardar",e.toString());
        }

    }
    public boolean validacion() {
        boolean correcto = false;

        try {
            //Formato de fecha (día/mes/año)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("MM/yyyy");
            formatoFecha.setLenient(false);
            //Comprobación de la fecha
            formatoFecha.parse(editTextfechacad.getText().toString());
            correcto = true;
            Toast.makeText(getApplicationContext(), "CORRECTO" ,Toast.LENGTH_LONG).show() ;
        } catch (ParseException e) {
            //Si la fecha no es correcta, pasará por aquí
            correcto = false;
            Toast.makeText(getApplicationContext(), "INCORRECTO" ,Toast.LENGTH_LONG).show() ;


        }

        return correcto;
    }

}