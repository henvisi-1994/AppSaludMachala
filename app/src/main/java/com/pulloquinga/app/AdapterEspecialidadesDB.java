package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.DetalleCentroMedico;

import java.util.ArrayList;

public class AdapterEspecialidadesDB extends RecyclerView.Adapter<AdapterEspecialidadesDB.ViewHolderDatos> {
    private final String tipo_medico;
    ArrayList<DetalleCentroMedico> detalle_centros_medicos=new ArrayList<DetalleCentroMedico>();
    //Context
    Context context;
    public AdapterEspecialidadesDB(ArrayList<DetalleCentroMedico> list_detalle_centro_medico,int id_centro_medico,String tipo_medico) {
        DetalleCentroMedico detalle_centro_medico=new DetalleCentroMedico();
        ArrayList<DetalleCentroMedico> aux=new ArrayList<DetalleCentroMedico>();
        this.tipo_medico=tipo_medico;
        aux = list_detalle_centro_medico;
        if(id_centro_medico!=0){
            for(int i=0;i<=aux.size()-1;i++){
                detalle_centro_medico=aux.get(i);
                if(detalle_centro_medico.getId_centroMedico()==id_centro_medico){
                    this.detalle_centros_medicos.add(detalle_centro_medico);
                }

            }
        }else{
            this.detalle_centros_medicos = list_detalle_centro_medico;
        }

    }

    @Override
    public AdapterEspecialidadesDB.ViewHolderDatos onCreateViewHolder( ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_especialidades,null,false);
        context=view.getContext();

        return new AdapterEspecialidadesDB.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder( AdapterEspecialidadesDB.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(detalle_centros_medicos.get(posicion));
        DetalleCentroMedico detalle_centro_medico=detalle_centros_medicos.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
                Intent detalle = new Intent(context, ListMedicos.class);
                detalle.putExtra("id_especialidad", detalle_centro_medico.getId_especialidad());
                detalle.putExtra("id_centroM", detalle_centro_medico.getId_centroMedico());
                detalle.putExtra("tipo_medico", tipo_medico);
                context.startActivity(detalle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return detalle_centros_medicos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView detalle_centro_medico;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            detalle_centro_medico=(TextView) itemView.findViewById(R.id.txvnombreespe);
        }
        public void asignarDatos(DetalleCentroMedico dato) {
            detalle_centro_medico.setText(dato.getNombre_especialidad());
            Log.d("asignarDatos ",dato.toString());
        }
    }
}
