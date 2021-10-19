package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.CentroMedico;
import com.pulloquinga.app.models.CentroMedicoDB;

import java.util.ArrayList;

public class AdapterCentrosMedicosDB extends RecyclerView.Adapter<AdapterCentrosMedicosDB.ViewHolderDatos>{
    private final String tipo_medico;
    ArrayList<CentroMedicoDB> listcentromedico;
    //Context
    Context context;
    public AdapterCentrosMedicosDB(ArrayList<CentroMedicoDB> listcentromedico, String tipo_medico) {
        this.listcentromedico = listcentromedico;
        this.tipo_medico=tipo_medico;
    }

    @Override
    public AdapterCentrosMedicosDB.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_centros_medicos,null,false);
        context=view.getContext();

        return new AdapterCentrosMedicosDB.ViewHolderDatos(view);    }

    @Override
    public void onBindViewHolder(AdapterCentrosMedicosDB.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listcentromedico.get(posicion));
        CentroMedicoDB centromedico=listcentromedico.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Mensajeeee",String.valueOf(centromedico.getId_centroMedico()));
                Intent detalle = new Intent(context, list_especialidades_db.class);
                detalle.putExtra("id_centromedico", centromedico.getId_centroMedico());
                detalle.putExtra("tipo_medico", tipo_medico);
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

        public void asignarDatos(CentroMedicoDB dato) {
            centromedico.setText(dato.getNombre_centroMedico());
        }
    }
}
