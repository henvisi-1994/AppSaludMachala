package com.pulloquinga.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTiposMedicos extends RecyclerView.Adapter<AdapterTiposMedicos.ViewHolderDatos> {
    ArrayList<String>listTiposMedicos;
    Context context;

    public AdapterTiposMedicos(ArrayList<String> listEspecialidades) {
        this.listTiposMedicos = listEspecialidades;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder( ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        context=view.getContext();

        return new AdapterTiposMedicos.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterTiposMedicos.ViewHolderDatos holder, @SuppressLint("RecyclerView") int posicion) {
        holder.asignarDatos(listTiposMedicos.get(posicion));
        //Noticia noticia=listnoticias.get(posicion);
        //CentroMedico centromedico=listTiposMedicos.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Pocision",String.valueOf(posicion));
                Intent detalle = new Intent(context, ListCentrosMedicosDB.class);

                switch (posicion){
                    case 0:
                        Log.d("tipomedico","Medico Fijo");
                        detalle.putExtra("tipo_medico", "Medico Fijo");
                        context.startActivity(detalle);
                        break;
                    case 1:
                        Log.d("tipomedico","Medico Produccion");
                        detalle.putExtra("tipo_medico", "Medico Produccion");
                        context.startActivity(detalle);
                        break;
                }


                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
               // Intent detalle = new Intent(context, DetalleCentroMedico.class);
                //detalle.putExtra("centromedico", "");
                //context.startActivity(detalle);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listTiposMedicos.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tipo_medi;
        public ViewHolderDatos( View itemView) {
            super(itemView);
            tipo_medi=(TextView) itemView.findViewById(R.id.txvlist);
        }
        public void asignarDatos(String dato) {
            tipo_medi.setText(dato);
        }
    }
}

