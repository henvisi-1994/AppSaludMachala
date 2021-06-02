package com.pulloquinga.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QuinesSomos extends AppCompatActivity {
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quines_somos);
    }
    public void fb(View view){
        url="https://www.facebook.com/RedSaludMachala";
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }
    public void tw(View view){
        url="https://twitter.com/redsaludmachala";
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }
    public void instagram(View view){
        url="https://www.instagram.com/redsaludmachala/";
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }
}