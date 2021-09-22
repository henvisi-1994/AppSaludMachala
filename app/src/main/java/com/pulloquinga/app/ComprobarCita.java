package com.pulloquinga.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;

public class ComprobarCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprobar_cita);
        TextView txt_nom_especialidad = (TextView) findViewById(R.id.txt_nom_especialidad);
        TextView txt_nom_medico=(TextView) findViewById(R.id.txt_nom_medico);
        TextView txt_fecha=(TextView) findViewById(R.id.txt_fecha);
        TextView txt_hora=(TextView) findViewById(R.id.txt_hora);
        Medico medico = (Medico) getIntent().getSerializableExtra("medico");
        Horario horario = (Horario) getIntent().getSerializableExtra("horario");
        txt_nom_especialidad.setText(medico.getNombre_especialidad());
        txt_nom_medico.setText(medico.getNombre_medico());
        txt_fecha.setText(horario.getFecha());
        txt_hora.setText(horario.getHora());
    }
}