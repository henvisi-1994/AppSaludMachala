package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.Config.ConfigCard;
import com.pulloquinga.app.Config.ConfigPagos;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.CentroMedico;
import com.pulloquinga.app.models.Email;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.RequestOUC;
import com.pulloquinga.app.models.RespuestaDeleteCard;
import com.pulloquinga.app.models.SolicitudDeleteCard;
import com.pulloquinga.app.models.TokenPago;
import com.pulloquinga.app.models.User;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterCards extends RecyclerView.Adapter<AdapterCards.ViewHolderDatos>  {
    ArrayList<Card> cards;
    //Context
    Context context;
    Medico medico;
    Horario horario;
    User usuario;
    private ApiService servicio= Config.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    private ApiService servicio_card= ConfigCard.getRetrofit().create(com.pulloquinga.app.interfaces.ApiService.class);
    public AdapterCards(ArrayList<Card> listcards, Medico medico,Horario horario,User usuario) {
        this.cards = listcards;
        this.medico=medico;
        this.horario=horario;
        this.usuario=usuario;
    }


    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tarjetas,null,false);
        context=view.getContext();

        return new AdapterCards.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterCards.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(cards.get(posicion));
        Card card=cards.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
                Intent detalle = new Intent(context, Pago.class);
                detalle.putExtra("card", card);
                detalle.putExtra("medico", medico);
                detalle.putExtra("horario", horario);
                context.startActivity(detalle);
            }
        });

    }

    @Override
    public int getItemCount() {return cards.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txt_num_tarjeta;
        TextView txt_nomb_titular;
        ImageView imagen;
        Button btn_deletcard;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            txt_num_tarjeta=(TextView) itemView.findViewById(R.id.txt_num_tarjeta);
            txt_nomb_titular=(TextView) itemView.findViewById(R.id.txt_nomb_titular);
            imagen= (ImageView) itemView.findViewById(R.id.img_card);
            btn_deletcard=(Button)itemView.findViewById(R.id.btn_deletcard);


        }
        public void asignarDatos(Card dato) {
            Log.d("CARD",dato.toString());
            String numero_tarjeta="XXXXXX"+dato.getNumber();
            String url_imagen="";
            String url="https://apiapp.saludmachala.gob.ec/img/logotarjetas/";
            txt_num_tarjeta.setText(numero_tarjeta);
            txt_nomb_titular.setText(dato.getHolderName());
            btn_deletcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    borrar_tarjeta(new SolicitudDeleteCard(usuario,dato));
                }
            });
            switch (dato.getType()){
                case "vi":
                    url_imagen=url+"ic_visa.png";
                    break;
                case "mc":
                    url_imagen=url+"ic_mastercard.png";
                    break;
                case "ax":
                    url_imagen=url+"ic_amex.png";
                    break;
                case "di":
                    url_imagen=url+"ic_diners.png";
                    break;
                case "dc":
                    url_imagen=url+"ic_discover.png";
                    break;
                case "ms":
                    url_imagen=url+"ic_maestro.png";
                    break;
            }
            Picasso.get()
                    .load(url_imagen)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imagen);
        }
    }
    public void regresar_gestion(){
        Intent principal = new Intent(context, GestionPago.class);
        context.startActivity(principal);

    }
    public void borrar_tarjeta(SolicitudDeleteCard solicitud_delete_card){
        Call<TokenPago> listCall = servicio.getTokenPago();
        listCall.enqueue(new Callback<TokenPago>() {
            @Override
            public void onResponse(Call<TokenPago> call, Response<TokenPago> response) {
                realizar_borrado(response.body().getAuthtoken(),solicitud_delete_card);
            }

            @Override
            public void onFailure(Call<TokenPago> call, Throwable t) {

            }
        });

    }
    public void realizar_borrado(String token, SolicitudDeleteCard solicitud_delete_card){
        Call<RespuestaDeleteCard> call = servicio_card.borrar_tarjeta(token,solicitud_delete_card);
        call.enqueue(new Callback<RespuestaDeleteCard>() {
            @Override
            public void onResponse(Call<RespuestaDeleteCard> call, Response<RespuestaDeleteCard> response) {
                try{
                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    Log.d("BORRADA TARJETA",response.body().getMessage());
                    regresar_gestion();
                }catch (Exception e){
                    Toast.makeText(context, "ERROR, NO SE PUEDE ELIMINAR TARJETA", Toast.LENGTH_LONG).show();
                    Log.d("ERROR","NO SE PUEDE ELIMINAR TARJETA");

                }

            }
            @Override
            public void onFailure(Call<RespuestaDeleteCard> call, Throwable t) {
                Log.d("Errorrrrr",t.toString());
            }
        });
    }

}
