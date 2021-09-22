package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;

import java.util.ArrayList;

public class AdapterMedico extends RecyclerView.Adapter<AdapterMedico.ViewHolderDatos>{
    private final String tipo_medico;
    ArrayList<Medico> listMedico=new ArrayList<Medico>();
    Context context;

    public AdapterMedico(ArrayList<Medico> listMedico,int id_especialidad,String tipo_medico) {
        Medico medico=new Medico();
        ArrayList<Medico> aux = new ArrayList<Medico>();
        this.tipo_medico=tipo_medico;
        aux = listMedico;
        for (int i = 0; i <= aux.size() - 1; i++) {
            medico = aux.get(i);
            if (medico.getId_especialidad() == id_especialidad) {
                this.listMedico.add(medico);
            }
        }
    }

    @Override
    public AdapterMedico.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        context=view.getContext();

        return new AdapterMedico.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder( AdapterMedico.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listMedico.get(posicion));
        Medico medico=listMedico.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (tipo_medico){
                    case "Medico Fijo":
                        Intent generar_cita = new Intent(context, GenerarCita.class);
                        generar_cita.putExtra("medico", medico);
                        context.startActivity(generar_cita);
                    break;
                    case "Medico Produccion":
                        break;
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return listMedico.size();    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView medico;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            medico=(TextView) itemView.findViewById(R.id.txvlist);

        }
        public void asignarDatos(Medico dato) {
            Log.d("Holaaaaaaaaa",dato.getNombre_medico());
            medico.setText(dato.getNombre_medico());
        }
    }
}
