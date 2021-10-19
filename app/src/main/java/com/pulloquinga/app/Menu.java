package com.pulloquinga.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Menu extends Fragment {

    public Menu() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
    public void noticias(View view){
        Intent noticias = new Intent(getActivity(), Noticias.class);
        startActivity(noticias);

    }
    public void contacto(View view){
        Intent contacto = new Intent(getActivity(), Contacto.class);
        startActivity(contacto);

    }
    public void inicio(View view){
        Intent inicio = new Intent(getActivity(), MainActivity.class);
        startActivity(inicio);

    }
}