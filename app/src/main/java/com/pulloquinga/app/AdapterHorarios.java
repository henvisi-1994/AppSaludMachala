package com.pulloquinga.app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;

import java.util.ArrayList;

public class AdapterHorarios extends RecyclerView.Adapter<AdapterHorarios.ViewHolderDatos>{
    ArrayList<Horario> listhorarios=new ArrayList<Horario>();
    Cita cita=new Cita();
    Medico medicog=new Medico();
    public AdapterHorarios(ArrayList<Horario> listhorarios, Medico medico) {

        this.cita.setId_especialidad(medico.getId_especialidad());
        this.cita.setId_medico(medico.getId_medico());
        Horario horario=new Horario();
        this.medicog=medico;
        ArrayList<Horario> aux=new ArrayList<Horario>();
        aux = listhorarios;

        for(int i=0;i<=aux.size()-1;i++){
            horario=aux.get(i);
            if( horario.getId_medico()==medico.getId_medico()){
                this.listhorarios.add(horario);
                Log.d("horarios Auxiliarrr",horario.toString());
            }
        }
    }

    //Context
    Context context;

    public ViewHolderDatos onCreateViewHolder( ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_horario,null,false);
        context=view.getContext();
        return new AdapterHorarios.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder( AdapterHorarios.ViewHolderDatos holder, int posicion) {
        holder.asignarDatos(listhorarios.get(posicion));
        Horario horario=listhorarios.get(posicion);
        this.cita.setId_horario(horario.getId_horario());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Log.d("Mensajeeee",String.valueOf(clic.getId()));
                Intent detalle = new Intent(context, ComprobarCita.class);
                detalle.putExtra("medico", medicog);
                detalle.putExtra("horario", horario);
                context.startActivity(detalle);

                Log.d("Cita",cita.toString());

            }
        });

    }

    @Override
    public int getItemCount() {
        return listhorarios.size();

    }

    public void filtrar(ArrayList<Horario> filtrarLista) {
        this.listhorarios = filtrarLista;
        notifyDataSetChanged();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txt_horario;
        public ViewHolderDatos( View itemView) {
            super(itemView);
            txt_horario=(TextView) itemView.findViewById(R.id.txt_horario);
        }

        public void asignarDatos(Horario horario) {
            txt_horario.setText(horario.getHora());
        }
    }
}
