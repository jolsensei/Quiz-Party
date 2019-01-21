package com.jolsensei.quizparty.Views;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.jolsensei.quizparty.R;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;


public class paginaPrincipal extends AppCompatActivity {

    UltraViewPager ultraViewPager;
    ViewPager viewPager;

    ArrayList<String> opcionesMenu = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pagina_principal);



    }


    public void irAMenuPartidas(View view) {

        Intent intent = new Intent(this, paginaListadoQuizs.class);

        startActivity(intent);

    }
}
