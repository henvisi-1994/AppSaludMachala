package com.pulloquinga.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable originalDrawable = getResources().getDrawable(R.drawable.ambulanciaicono);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());
        ImageView imageView = (ImageView) findViewById(R.id.ambulancia);
        imageView.setImageDrawable(roundedDrawable);

        //Imagen Quienes Somos
        Drawable originalDrawableqs = getResources().getDrawable(R.drawable.quienessomos);
        Bitmap originalBitmapqs = ((BitmapDrawable) originalDrawableqs).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawableqs = RoundedBitmapDrawableFactory.create(getResources(), originalBitmapqs);

        //asignamos el CornerRadius
        roundedDrawableqs.setCornerRadius(originalBitmap.getHeight());
        ImageView imageViewqs = (ImageView) findViewById(R.id.quines_somos);
        imageViewqs.setImageDrawable(roundedDrawableqs);

        //Imagen Centros Medicos
        Drawable originalDrawablecm = getResources().getDrawable(R.drawable.cmmicono);
        Bitmap originalBitmapcm = ((BitmapDrawable) originalDrawablecm).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawablecm = RoundedBitmapDrawableFactory.create(getResources(), originalBitmapcm);

        //asignamos el CornerRadius
        roundedDrawablecm.setCornerRadius(originalBitmap.getHeight());
        ImageView imageViewcm = (ImageView) findViewById(R.id.centro_medico);
        imageViewcm.setImageDrawable(roundedDrawablecm);

        //Imagen Clinicas Moviles
        Drawable originalDrawablecmo = getResources().getDrawable(R.drawable.cmicono);
        Bitmap originalBitmapcmo = ((BitmapDrawable) originalDrawablecmo).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawablecmo = RoundedBitmapDrawableFactory.create(getResources(), originalBitmapcmo);

        //asignamos el CornerRadius
        roundedDrawablecmo.setCornerRadius(originalBitmap.getHeight());
        ImageView imageViewcmo = (ImageView) findViewById(R.id.clinica_movil);
        imageViewcmo.setImageDrawable(roundedDrawablecmo);

    }
    public void centrosmedicos(View view){
        Intent cetroMedico = new Intent(this, CentrosMedicos.class);
        startActivity(cetroMedico);

    }
    public void jornadasmedicas(View view){
        Intent jornadasmedicas = new Intent(this, JornadasMedicas.class);
        startActivity(jornadasmedicas);
    }
    public void ambulancia(View view){
        Intent ambulancia = new Intent(this, Ambulancia.class);
        startActivity(ambulancia);

    }

    public void clinicas_moviles(View view){
        Intent clinicas_moviles = new Intent(this, ClinicasMoviles.class);
        startActivity(clinicas_moviles);

    }
    public void quienes_somos(View view){
        Intent quienes_somos = new Intent(this, QuinesSomos.class);
        startActivity(quienes_somos);
    }
    public void fb(View view){
        startActivity(Recursos.enlaces("https://www.facebook.com/RedSaludMachala"));
    }
    public void tw(View view){
        startActivity(Recursos.enlaces("https://twitter.com/redsaludmachala"));
    }
    public void instagram(View view){
        startActivity(Recursos.enlaces("https://www.instagram.com/redsaludmachala/"));
    }
    public void noticias(View view){
        Intent noticias = new Intent(this, Noticias.class);
        startActivity(noticias);

    }
    public void contacto(View view){
        Intent contacto = new Intent(this, Contacto.class);
        startActivity(contacto);

    }


}