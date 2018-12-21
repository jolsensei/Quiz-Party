package com.jolsensei.quizparty.Views;

import android.animation.LayoutTransition;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapter;
import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapterOnClickHandler;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.opcionMenu;
import com.jolsensei.quizparty.Menus.BottomSheetDialog;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.listadoQuizVM;

import java.util.ArrayList;

public class paginaListadoQuizs extends AppCompatActivity implements listadoQuizAdapterOnClickHandler,
                                                                        View.OnClickListener, BottomSheetDialog.BottomSheetListener {

    private RecyclerView listadoQuiz;

    private listadoQuizVM miVM;
    private listadoQuizAdapter miAdapter;

    private static int ultimoSeleccionado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_listado_quizs);


        miVM = ViewModelProviders.of(this).get(listadoQuizVM.class);

        listadoQuiz = findViewById(R.id.rvListadoQuiz);

        listadoQuiz.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());

        listadoQuiz.setLayoutManager(llm);

        miAdapter = new listadoQuizAdapter(this);
        miAdapter.setQuizData(miVM.getListadoQuiz().getValue());

        listadoQuiz.setAdapter(miAdapter);

//        final Observer<ArrayList<Quiz>> miVMobserver = new Observer<ArrayList<Quiz>>() {
//            @Override
//            public void onChanged(@Nullable ArrayList<Quiz> quizzes) {
//
//
//                miAdapter.setQuizData(quizzes);
//
//
//
//            }
//        };
//
//
//        miVM.getListadoQuiz().observe(this, miVMobserver);

    }

    public void volverAtras(View view) {


        super.onBackPressed();

    }

    @Override
    public void onClick(View view) {




    }

    @Override
    public boolean onLongClick(int adapterPosition) {

        BottomSheetDialog bottomSheet = new BottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

        ultimoSeleccionado = adapterPosition;


        return true;
    }

    @Override
    public void onClick(int adapterPosition) {

        Intent intent = new Intent(this, DialogDificultad.class);

        startActivity(intent);


    }

    @Override
    public void onButtonClicked(opcionMenu opcion) {

        if (opcion == opcionMenu.BORRAR){


            miAdapter.borrar(ultimoSeleccionado);
            //miVM.getListadoQuiz().getValue();


        }else {

            Toast.makeText(this, opcion.toString(), Toast.LENGTH_SHORT).show();

        }




    }
}
