package com.pulloquinga.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

import com.pulloquinga.app.models.Noticia;
import com.squareup.picasso.Picasso;

public class DetalleNoticia extends AppCompatActivity {
    EditText editTextdesarrollonoticia;
    ImageView imgdetallenoticia;
    TextView txtvtitulonoticia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_noticia);
        editTextdesarrollonoticia=(EditText) findViewById(R.id.editTextdesarrollonoticia);
        Recursos.texto_no_editable(editTextdesarrollonoticia);
        imgdetallenoticia=(ImageView) findViewById(R.id.imgdetallenoticia);
        txtvtitulonoticia=(TextView) findViewById(R.id.txtvtitulonoticia);

        //editTextdesarrollonoticia.setMovementMethod(new ScrollingMovementMethod());
        Noticia noticia = (Noticia) getIntent().getSerializableExtra("noticia");
        txtvtitulonoticia.setText(noticia.getTitulo_noticia());
        editTextdesarrollonoticia.setText(noticia.getDescripcion_noticia());
        Picasso.get()
                .load(noticia.getImagen_noticia())
                .error(R.mipmap.ic_launcher_round)
                .into(imgdetallenoticia);
    }
    public void inicio(View view){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }
    public void noticias(View view){
        Intent noticias = new Intent(this, Noticias.class);
        startActivity(noticias);
    }


}