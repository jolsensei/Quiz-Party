package com.jolsensei.quizparty.Views;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.Toast;

import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapter;
import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapterOnClickHandler;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.difficulties;
import com.jolsensei.quizparty.Entidades.opcionMenu;
import com.jolsensei.quizparty.Menus.BottomSheetDialog;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.listadoQuizVM;

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

        miVM.loadQuizs(this);

        listadoQuiz = findViewById(R.id.rvListadoQuiz);

        listadoQuiz.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());

        listadoQuiz.setLayoutManager(llm);

        miAdapter = new listadoQuizAdapter(this);
        miAdapter.setQuizData(miVM.getListadoQuiz().getValue());

        listadoQuiz.setAdapter(miAdapter);


    }

    @Override
    protected void onRestart() {
        super.onRestart();


        miVM.loadQuizs(this);

        miAdapter.setQuizData(miVM.getListadoQuiz().getValue());
    }



    public void volverAtras(View view) {


        super.onBackPressed();

    }

    @Override
    public void onClick(View view) {




    }

    @Override
    public boolean onLongClick(int adapterPosition) {

        ultimoSeleccionado = adapterPosition;

        BottomSheetDialog bottomSheet = new BottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");


        return true;
    }

    @Override
    public void onClick(int adapterPosition) {

        ultimoSeleccionado = adapterPosition;

        Intent intent = new Intent(this, DialogDificultad.class);

        startActivityForResult(intent, 1);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Intent intent = new Intent(this, jugandoQuiz.class);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){

                difficulties result = (difficulties) data.getSerializableExtra("result");


                intent.putExtra("quiz", miAdapter.obtenerNombreQuizSegunPosicion(ultimoSeleccionado));
                intent.putExtra("dificulty", result);
                startActivity(intent);


            }
        }
    }

    @Override
    public void onButtonClicked(opcionMenu opcion) {

        if (opcion == opcionMenu.BORRAR){

            miAdapter.borrar(ultimoSeleccionado, this);


            
        }else {

            Toast.makeText(this, opcion.toString(), Toast.LENGTH_SHORT).show();

        }




    }

    public void addQuiz(View view) {


        Intent intent = new Intent(this, nuevoQuiz.class);

        startActivity(intent);

    }
}
