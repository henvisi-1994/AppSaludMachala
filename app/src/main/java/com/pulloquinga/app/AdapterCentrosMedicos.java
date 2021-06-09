package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pulloquinga.app.models.CentroMedico;

import java.util.ArrayList;

public class AdapterCentrosMedicos extends RecyclerView.Adapter<AdapterCentrosMedicos.ViewHolderDatos> {
    ArrayList<CentroMedico> listcentromedico;
    //Context
    Context context;

    public AdapterCentrosMedicos(ArrayList<CentroMedico> listcentromedico) {
        this.listcentromedico = listcentromedico;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_centros_medicos,null,false);
        context=view.getContext();

        return new AdapterCentrosMedicos.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterCentrosMedicos.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listcentromedico.get(posicion));
        CentroMedico centromedico=listcentromedico.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
                Intent detalle = new Intent(context, DetalleCentroMedico.class);
                detalle.putExtra("centromedico", centromedico);
                context.startActivity(detalle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listcentromedico.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView centromedico;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            centromedico=(TextView) itemView.findViewById(R.id.txvnombrecm);

        }

        public void asignarDatos(CentroMedico dato) {

            centromedico.setText(dato.getNombre());
        }
    }
}
