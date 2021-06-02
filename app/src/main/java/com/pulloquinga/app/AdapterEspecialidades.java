package com.pulloquinga.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterEspecialidades extends RecyclerView.Adapter<AdapterEspecialidades.ViewHolderDatos> {
    ArrayList<String>listEspecialidades;

    public AdapterEspecialidades(ArrayList<String> listEspecialidades) {
        this.listEspecialidades = listEspecialidades;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterEspecialidades.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listEspecialidades.get(posicion));
    }

    @Override
    public int getItemCount() {
        return listEspecialidades.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView especialidad;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            especialidad=(TextView) itemView.findViewById(R.id.txvlist);
        }

        public void asignarDatos(String dato) {
            especialidad.setText(dato);
        }
    }
}
