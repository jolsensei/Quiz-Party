package com.jolsensei.quizparty.Views;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;


import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.jolsensei.quizparty.Adaptadores.MyPagerAdapter;
import com.jolsensei.quizparty.Entidades.tarjetaMenu;
import com.jolsensei.quizparty.R;


import java.util.ArrayList;


public class paginaPrincipal extends AppCompatActivity {



    ArrayList<tarjetaMenu> opcionesMenu = new ArrayList<>();
    HorizontalInfiniteCycleViewPager infiniteCycleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pagina_principal);

        infiniteCycleViewPager = findViewById(R.id.cycleView);

        opcionesMenu.add(new tarjetaMenu("JUGAR", R.drawable.iconojugar, "¡Reune a tus amigos y disfruta!"));
        opcionesMenu.add(new tarjetaMenu("CONTACTO", R.drawable.reportbug, "Reporta errores y contribuye a mejorar la aplicacion"));
        opcionesMenu.add(new tarjetaMenu("WEB MARKET", R.drawable.market, "Descarga contenido creado por otros usuarios"));


        MyPagerAdapter adapter = new MyPagerAdapter(opcionesMenu);
        infiniteCycleViewPager.setAdapter(adapter);


        infiniteCycleViewPager.setMediumScaled(true);
        infiniteCycleViewPager.setMaxPageScale(0.8F);
        infiniteCycleViewPager.setMinPageScale(0.5F);
        infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
        infiniteCycleViewPager.setMinPageScaleOffset(5.0F);
        infiniteCycleViewPager.setScrollDuration(2000);






    }


    public void irAMenuPartidas(View view) {

        Intent intent = new Intent(this, paginaListadoQuizs.class);

        startActivity(intent);

    }
}
