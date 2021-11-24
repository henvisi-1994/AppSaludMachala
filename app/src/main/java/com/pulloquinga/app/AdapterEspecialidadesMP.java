package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Especialidad;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterEspecialidadesMP extends RecyclerView.Adapter<AdapterEspecialidadesMP.ViewHolderDatos> {
    ArrayList<Especialidad> listEspecialidades;
    Context context;
    private final String tipo_medico;
    public AdapterEspecialidadesMP(ArrayList<Especialidad> listEspecialidades,String tipo_medico) {
        this.listEspecialidades = listEspecialidades;
        this.tipo_medico=tipo_medico;
    }
    @Override
    public AdapterEspecialidadesMP.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_especialidades,null,false);
        context=view.getContext();
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterEspecialidadesMP.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listEspecialidades.get(posicion));
        Especialidad especialidad=listEspecialidades.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
                Intent detalle = new Intent(context, ListMedicos.class);
                detalle.putExtra("id_especialidad", especialidad.getId_especialidad());
                detalle.putExtra("tipo_medico", tipo_medico);
                context.startActivity(detalle);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listEspecialidades.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView especialidad;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            especialidad=(TextView) itemView.findViewById(R.id.txvnombreespe);
        }

        public void asignarDatos(Especialidad dato) {
            especialidad.setText(dato.getNombre_especialidad());
        }
    }
}
