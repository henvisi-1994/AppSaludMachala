package com.pulloquinga.app.interfaces;

import com.pulloquinga.app.models.CentroMedicoDB;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Especialidad;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("noticias")
    Call<List<Noticia>> getNoticias();
    @GET("centros_medicos")
    Call<List<CentroMedicoDB>> getCentrosMedicos();
    @GET("especialidades")
    Call<List<Especialidad>> getEspecialidad();
    @GET("medicos")
    Call<List<Medico>> getMedico();
    @GET("detalle_centro_medico")
    Call<List<DetalleCentroMedico>> getDetalleCentroMedico();
    @GET("horarios")
    Call<List<Horario>> getHorarios();
}
