package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.RespuestaHistorial;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterHistorial extends RecyclerView.Adapter<AdapterHistorial.ViewHolderDatos> {
    ArrayList<RespuestaHistorial> listhistorial;
    Context context;

    public AdapterHistorial(ArrayList<RespuestaHistorial> listhistorial) {
        this.listhistorial = listhistorial;
    }
    @NonNull
    @NotNull
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_historial,null,false);
        context=view.getContext();
        return new AdapterHistorial.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterHistorial.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listhistorial.get(posicion));
        RespuestaHistorial rh=listhistorial.get(posicion);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
                Intent capp = new Intent(context, CalificacionApp.class);
                capp.putExtra("id_cita", rh.getIdCita());
                context.startActivity(capp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listhistorial.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txtcent_medico,txt_esp,txt_nombm,txt_fech,txt_hora;
        public ViewHolderDatos( View itemView) {
            super(itemView);
            txtcent_medico=(TextView) itemView.findViewById(R.id.txtcent_medico);
            txt_esp=(TextView) itemView.findViewById(R.id.txt_esp);
            txt_nombm=(TextView) itemView.findViewById(R.id.txt_nombm);
            txt_fech=(TextView) itemView.findViewById(R.id.txt_fech);
            txt_hora=(TextView) itemView.findViewById(R.id.txt_hora);

        }
        public void asignarDatos(RespuestaHistorial dato) {
            txtcent_medico.setText(dato.getNombre_centroMedico());
            txt_esp.setText(dato.getNombreEspecialidad());
            txt_nombm.setText(dato.getNombreMedico());
            txt_fech.setText(dato.getFecha());
            txt_hora.setText(dato.getHora().split("-")[0]);
        }
    }
}

