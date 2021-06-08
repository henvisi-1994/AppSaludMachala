package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pulloquinga.app.models.Noticia;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterNoticias extends RecyclerView.Adapter<AdapterNoticias.ViewHolderDatos>{
    ArrayList<Noticia> listnoticias;

    public AdapterNoticias(ArrayList<Noticia> listnoticias) {
        this.listnoticias = listnoticias;
    }

    //Context
    Context context;
    @Override
    public AdapterNoticias.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_noticias,null,false);
        context=view.getContext();
        return new AdapterNoticias.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterNoticias.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listnoticias.get(posicion));
        Noticia noticia=listnoticias.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detalle = new Intent(context, DetalleNoticia.class);
                detalle.putExtra("noticia", noticia);
                context.startActivity(detalle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listnoticias.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imagen;
        TextView txvfecha;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            titulo=(TextView) itemView.findViewById(R.id.txmltitulo);
            imagen= (ImageView) itemView.findViewById(R.id.imgvimagen_noticia);
            txvfecha=(TextView) itemView.findViewById(R.id.txvfecha);
        }
        public void asignarDatos(Noticia dato) {
            String cadenaFecha []=dato.getFecha_inicio_noticia().split(" ",10);
            titulo.setText(dato.getTitulo_noticia());
            Picasso.get()
                    .load(dato.getImagen_noticia())
                    .resize(30, 30)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imagen);
            txvfecha.setText(cadenaFecha[0]);
        }
    }
}
