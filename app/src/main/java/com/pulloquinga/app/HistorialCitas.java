package com.pulloquinga.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.pulloquinga.app.Config.Config;
import com.pulloquinga.app.interfaces.ApiService;
import com.pulloquinga.app.models.DetalleCentroMedico;
import com.pulloquinga.app.models.RespuestaHistorial;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialCitas extends AppCompatActivity {
    private ApiService servicio = Config.getRetrofit().create(ApiService.class);
    ArrayList<RespuestaHistorial> hist_citas = new ArrayList();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_citas);
        recycler = (RecyclerView) findViewById(R.id.r_historial);
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        //recycler.setLayoutManager(new GridLayoutManager(this, 2));
        //int spanCount = 2; // 3 columns
        // int spacing = 30; // 50px
        //boolean includeEdge = false;
        //recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        InizializaDati();
    }

    private void InizializaDati() {
        Call<List<RespuestaHistorial>> listCall;
        SharedPreferences prefs = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        int id_usuario= prefs.getInt("usuario_id", 0); // prefs.getString("nombre del campo" , "valor por defecto")
        String token = "Bearer " + prefs.getString("token", ""); // prefs.getString("nombre del campo" , "valor por defecto")
        listCall = servicio.obtener_historial(token,id_usuario);
        listCall.enqueue(new Callback<List<RespuestaHistorial>>() {
            @Override
            public void onResponse(Call<List<RespuestaHistorial>> call, Response<List<RespuestaHistorial>> response) {
                if (response.isSuccessful()) {
                    hist_citas = (Recursos.listToArrayList(response.body()));
                    AdapterHistorial adapter = new AdapterHistorial(hist_citas);
                    recycler.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<RespuestaHistorial>> call, Throwable t) {
                Log.d("ERROR HISTORIAL",t.toString());
            }
        });
    }
}