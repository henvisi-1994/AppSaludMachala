package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

            Paymentez.addCard(this, "0701115677", "henvisi1994@gmail.com", cardToSave, new TokenCallback() {

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

        }catch (Exception e)
        {
            Log.d("Error Guardar",e.toString());
        }

    }

}