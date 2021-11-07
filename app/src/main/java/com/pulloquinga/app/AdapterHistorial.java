package com.pulloquinga.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.RespuestaHistorial;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterHistorial extends RecyclerView.Adapter<AdapterHistorial.ViewHolderDatos> {
    ArrayList<RespuestaHistorial> listhistorial;

    public AdapterHistorial(ArrayList<RespuestaHistorial> listhistorial) {
        this.listhistorial = listhistorial;
    }
    @NonNull
    @NotNull
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_historial,null,false);

        return new AdapterHistorial.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterHistorial.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listhistorial.get(posicion));
    }

    @Override
    public int getItemCount() {
        return listhistorial.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txtcent_medico,txt_esp,txt_nombm,txt_fech;
        public ViewHolderDatos( View itemView) {
            super(itemView);
            txtcent_medico=(TextView) itemView.findViewById(R.id.txtcent_medico);
            txt_esp=(TextView) itemView.findViewById(R.id.txt_esp);
            txt_nombm=(TextView) itemView.findViewById(R.id.txt_nombm);
            txt_fech=(TextView) itemView.findViewById(R.id.txt_fech);

        }
        public void asignarDatos(RespuestaHistorial dato) {
            txtcent_medico.setText(dato.getNombre_centroMedico());
            txt_esp.setText(dato.getNombreEspecialidad());
            txt_nombm.setText(dato.getNombreMedico());
            txt_fech.setText(dato.getFecha());

        }
    }
}

