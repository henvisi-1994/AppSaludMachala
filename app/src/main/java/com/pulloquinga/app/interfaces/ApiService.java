package com.pulloquinga.app.interfaces;

import com.pulloquinga.app.models.CentroMedicoDB;
import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Especialidad;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;
import com.pulloquinga.app.models.RespuestaLoguin;
import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.TokenPago;
import com.pulloquinga.app.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("noticias")
    Call<List<Noticia>> getNoticias();
    @GET("centros_medicos")
    Call<List<CentroMedicoDB>> getCentrosMedicos();
    @GET("especialidades")
    Call<List<Especialidad>> getEspecialidad();
    @GET("especialidades")
    Call<List<DetalleCentroMedico>> getEspecialidades();
    @GET("medicos")
    Call<List<Medico>> getMedico();
    @GET("detalle_centro_medico")
    Call<List<DetalleCentroMedico>> getDetalleCentroMedico();
    @GET("horarios")
    Call<List<Horario>> getHorarios();
    @POST("logueo")
    Call<RespuestaLoguin> loggearse(@Body Usuario usuario);
    @POST("usuario")
    Call<RespuestaServer> registro(@Body Usuario usuario);
    @POST("citas")
    Call<Cita> registro_cita(@Header("Authorization") String content_type,@Body Cita cita);
    @DELETE("horarios/{id}")
    Call<RespuestaServer> eliminar_horario(@Header("Authorization") String content_type, @Path("id")int id);
    @GET("medicos_produccion")
    Call<List<Medico>> getMedicoProduccion();
    @GET("list")
    Call<List<Card>> obtener_tarjeta(@Header("Auth-Token") String content_type, @Query("uid")String uid);
    @GET("obetener_token_pago")
    Call <TokenPago> getTokenPago();
}
