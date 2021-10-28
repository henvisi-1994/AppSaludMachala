package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.CentroMedico;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterCards extends RecyclerView.Adapter<AdapterCards.ViewHolderDatos>  {
    ArrayList<Card> cards;
    //Context
    Context context;
    Medico medico;
    Horario horario;

    public AdapterCards(ArrayList<Card> listcards, Medico medico,Horario horario) {
        this.cards = listcards;
        this.medico=medico;
        this.horario=horario;
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

        public ViewHolderDatos(View itemView) {
            super(itemView);
            txt_num_tarjeta=(TextView) itemView.findViewById(R.id.txt_num_tarjeta);
            txt_nomb_titular=(TextView) itemView.findViewById(R.id.txt_nomb_titular);
            imagen= (ImageView) itemView.findViewById(R.id.img_card);


        }
        public void asignarDatos(Card dato) {
            String numero_tarjeta="XXXXXX"+dato.getNumber();
            String url_imagen="";
            String url="https://apiapp.saludmachala.gob.ec/img/logotarjetas/";
            txt_num_tarjeta.setText(numero_tarjeta);
            txt_nomb_titular.setText(dato.getHolderName());
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

}
