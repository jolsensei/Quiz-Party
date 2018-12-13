package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapter;
import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapterOnClickHandler;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.listadoQuizVM;

public class paginaListadoQuizs extends AppCompatActivity implements listadoQuizAdapterOnClickHandler, View.OnClickListener {

    private RecyclerView listadoQuiz;
    private LinearLayout menuOpciones;

    private listadoQuizVM miVM;
    private listadoQuizAdapter miAdapter;

    private static boolean menuVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_listado_quizs);

        menuOpciones = (LinearLayout) findViewById(R.id.menuEditarBorrar);

        miVM = ViewModelProviders.of(this).get(listadoQuizVM.class);

        listadoQuiz = findViewById(R.id.rvListadoQuiz);

        listadoQuiz.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());

        listadoQuiz.setLayoutManager(llm);

        miAdapter = new listadoQuizAdapter(this);
        miAdapter.setQuizData(miVM.getListadoQuiz().getValue());

        listadoQuiz.setAdapter(miAdapter);


    }

    public void volverAtras(View view) {

        //Intent intent = new Intent(this, paginaPrincipal.class);

        //startActivity(intent);

        //finish();
        super.onBackPressed();

    }

    @Override
    public void onClick(View view) {

        if (view.getId() != R.id.menuEditarBorrar ){

            menuOpciones.setVisibility(View.GONE);

        }

        Toast.makeText(this, "Probandooooo", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onLongClick(int adapterPosition) {

        Context context = this;


        //menuOpciones.animate().translationY(0);
        menuOpciones.setVisibility(View.VISIBLE);
       // Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
       // menuOpciones.startAnimation(slideUp);
        menuVisible = true;



        return true;
    }

    @Override
    public void onClick(int adapterPosition) {

        Context context = this;

        if (menuVisible){


            menuOpciones.setVisibility(View.GONE);
            menuVisible = false;

        }else {

            Toast.makeText(this, "Probando", Toast.LENGTH_SHORT).show();
        }



    }

}
