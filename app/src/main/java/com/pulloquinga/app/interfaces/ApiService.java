package com.pulloquinga.app.interfaces;

import com.pulloquinga.app.CalificacionApp;
import com.pulloquinga.app.models.CalificacionAppModel;
import com.pulloquinga.app.models.CentroMedicoDB;
import com.pulloquinga.app.models.Cita;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.Email;
import com.pulloquinga.app.models.Especialidad;
import com.pulloquinga.app.models.Horario;
import com.pulloquinga.app.models.Medico;
import com.pulloquinga.app.models.Noticia;
import com.pulloquinga.app.models.OUC;
import com.pulloquinga.app.models.RequestOUC;
import com.pulloquinga.app.models.RequireCalificacion;
import com.pulloquinga.app.models.RequireEmail;
import com.pulloquinga.app.models.EmailComprobante;
import com.pulloquinga.app.models.RequireEmailComprobante;
import com.pulloquinga.app.models.RespuestaDeleteCard;
import com.pulloquinga.app.models.RespuestaHistorial;
import com.pulloquinga.app.models.RespuestaLoguin;
import com.pulloquinga.app.models.RespuestaServer;
import com.pulloquinga.app.models.Card;
import com.pulloquinga.app.models.RespuestaServerValidacion;
import com.pulloquinga.app.models.SolicitudDeleteCard;
import com.pulloquinga.app.models.TokenPago;
import com.pulloquinga.app.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("noticias")
    Call<List<Noticia>> getNoticias();
    @GET("centros_medicos")
    Call<List<CentroMedicoDB>> getCentrosMedicos();
    @GET("especialidades")
    Call<List<Especialidad>> getEspecialidad();
    @GET("especialidades_med_prod")
    Call<List<Especialidad>> getEspecialidadMedProd();
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
    @POST("verificar_registro")
    Call<RespuestaServerValidacion> verificar_registro(@Body Usuario usuario);
    @POST("citas")
    Call<Cita> registro_cita(@Header("Authorization") String content_type, @Body Cita cita);
    @DELETE("horarios/{id}")
    Call<RespuestaServer> eliminar_horario(@Header("Authorization") String content_type, @Path("id")int id);
    @GET("medicos_produccion")
    Call<List<Medico>> getMedicoProduccion();
    @GET("obtener_tarjeta/{identificacion}")
    Call<List<Card>> obtener_tarjeta(@Path("identificacion")String identificacion);
    @GET("obetener_token_pago")
    Call <TokenPago> getTokenPago();
    @POST("debit")
    Call<RequestOUC> generar_pago(@Header("Auth-Token") String content_type, @Body OUC ouc);
    @POST("email_cita")
    Call<RequireEmail> enviar_email(@Header("Authorization") String content_type, @Body Email email);
    @POST("email_comprobante")
    Call<RequireEmailComprobante> enviar_comprobante(@Header("Authorization") String content_type, @Body EmailComprobante email);
    @POST("update_usuario")
    Call<RespuestaServer> update_usuario(@Header("Authorization") String content_type, @Body Usuario usuario);
    @GET("historial/{id}")
    Call<List<RespuestaHistorial>> obtener_historial(@Header("Authorization") String content_type,@Path("id")int id);
    @POST("delete")
    Call<RespuestaDeleteCard> borrar_tarjeta(@Header("Auth-Token") String content_type, @Body SolicitudDeleteCard solicituddc);
    @POST("calificacion_app")
    Call<RequireCalificacion> calificar_app(@Header("Authorization") String content_type, @Body CalificacionAppModel calapp);
}
