package com.jolsensei.quizparty.Views;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.jolsensei.quizparty.Adaptadores.MyPagerAdapter;
import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.tarjetaMenu;
import com.jolsensei.quizparty.R;
import com.tiagosantos.enchantedviewpager.EnchantedViewPager;


import java.util.ArrayList;


public class paginaPrincipal extends AppCompatActivity {



    ArrayList<tarjetaMenu> opcionesMenu = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pagina_principal);


        opcionesMenu.add(new tarjetaMenu("QUIZ", R.drawable.iconojugar, "¡Reune a tus amigos y juega!"));
        opcionesMenu.add(new tarjetaMenu("DADO", R.drawable.dice, "Por si no tienes uno a mano ;)"));
        opcionesMenu.add(new tarjetaMenu("CONTACTO", R.drawable.contacto, "Contribuye a mejorar la aplicacion"));
        opcionesMenu.add(new tarjetaMenu("MARKET", R.drawable.market, "Descarga contenido creado por otros usuarios"));



        final EnchantedViewPager ePager = findViewById(R.id.ePager);


        MyPagerAdapter adapter = new MyPagerAdapter(this, opcionesMenu);
        adapter.enableCarrousel();

        ePager.setAdapter(adapter);
        ePager.useScale();
        ePager.useAlpha();
        ePager.setCurrentItem(adapter.getMiddlePosition());
        ePager.setPageMargin(-100);



    }


    public static void setupData(final View view, final tarjetaMenu opcion){

        TextView titulo, icono, descripcion;

        titulo = view.findViewById(R.id.tituloOpcion);
        titulo.setText(opcion.getNombreOpcion());

        icono = view.findViewById(R.id.iconoOpcion);
        icono.setBackgroundResource(opcion.getIconoOpcion());


        descripcion = view.findViewById(R.id.descripcionOpcion);
        descripcion.setText(opcion.getDescripcionOpcion());
    }


    public static void execOption(View view, int opcion){

        Intent  intent = null;


        switch (opcion){

            case R.drawable.iconojugar:

                intent = new Intent(view.getContext(), paginaListadoQuizs.class);

            break;

            case R.drawable.market:

                //Para ir metiendo datos
                Repositories r = new Repositories();

                r.insertNewData(view.getContext());

                break;

            case R.drawable.dice:


                intent = new Intent(view.getContext(), diceTable.class);

                break;


        }

        if (intent != null){

            view.getContext().startActivity(intent);
        }



    }
}
