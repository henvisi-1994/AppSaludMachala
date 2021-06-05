package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
        Noticia clic=listnoticias.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detalle = new Intent(context, DetalleCentroMedico.class);
                detalle.putExtra("id", clic.getId_noticia());
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
        public ViewHolderDatos(View itemView) {
            super(itemView);
            titulo=(TextView) itemView.findViewById(R.id.txmltitulo);
            imagen= (ImageView) itemView.findViewById(R.id.imgvimagen_noticia);
        }
        public void asignarDatos(Noticia dato) {
            titulo.setText(dato.getTitulo());
        }
    }
}
