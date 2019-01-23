package com.jolsensei.quizparty.Views;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;


import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.jolsensei.quizparty.Adaptadores.MyPagerAdapter;
import com.jolsensei.quizparty.Entidades.tarjetaMenu;
import com.jolsensei.quizparty.R;


import java.util.ArrayList;


public class paginaPrincipal extends AppCompatActivity {



    ArrayList<tarjetaMenu> opcionesMenu = new ArrayList<>();
    //HorizontalInfiniteCycleViewPager infiniteCycleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pagina_principal);

        final HorizontalInfiniteCycleViewPager infiniteCycleViewPager = findViewById(R.id.cycleView);

        infiniteCycleViewPager.setAdapter(new MyPagerAdapter(this));


//        infiniteCycleViewPager.setMediumScaled(true);
//        infiniteCycleViewPager.setMaxPageScale(0.8F);
//        infiniteCycleViewPager.setMinPageScale(0.5F);
//        infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
//        infiniteCycleViewPager.setMinPageScaleOffset(5.0F);
//        infiniteCycleViewPager.setScrollDuration(2000);






    }


    public void irAMenuPartidas(View view) {

        Intent intent = new Intent(this, paginaListadoQuizs.class);

        startActivity(intent);

    }

    public static void setupData(final View view, final tarjetaMenu opcion){

        final TextView titulo, icono, descripcion;

        titulo = view.findViewById(R.id.tituloOpcion);
        titulo.setText(opcion.getNombreOpcion());

        icono = view.findViewById(R.id.iconoOpcion);
        icono.setBackgroundResource(opcion.getIconoOpcion());


        descripcion = view.findViewById(R.id.descripcionOpcion);
        descripcion.setText(opcion.getDescripcionOpcion());
    }
}
