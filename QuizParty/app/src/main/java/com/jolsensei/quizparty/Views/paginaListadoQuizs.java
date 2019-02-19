package com.jolsensei.quizparty.Views;


import android.app.Activity;
import android.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapter;
import com.jolsensei.quizparty.Adaptadores.listadoQuizAdapterOnClickHandler;

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

    private TextView atras, nuevo;

    Animation touch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_listado_quizs);

        atras = findViewById(R.id.volverIcon);
        nuevo = findViewById(R.id.addIcon);

        touch = AnimationUtils.loadAnimation(this, R.anim.touch);

        miVM = ViewModelProviders.of(this).get(listadoQuizVM.class);

        miVM.loadQuizs(this);

        listadoQuiz = findViewById(R.id.rvListadoQuiz);

        listadoQuiz.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());

        listadoQuiz.setLayoutManager(llm);

        miAdapter = new listadoQuizAdapter(this, this);
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

        atras.startAnimation(touch);

        super.onBackPressed();

    }

    @Override
    public void onClick(View view) {




    }

    @Override
    public boolean onLongClick(int adapterPosition) {

        ultimoSeleccionado = adapterPosition;

        BottomSheetDialog bottomSheet = new BottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), "bottomSheet");


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

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.dialogTitle);
            builder.setMessage(R.string.dialogMessage)
                    .setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {


                            miAdapter.borrar(ultimoSeleccionado, getApplicationContext());

                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {



                            dialog.dismiss();
                        }
                    });

            builder.create();
            builder.show();



            
        }else { //Editar

            Intent intent = new Intent(this, editQuiz.class);

            intent.putExtra("quiz", miAdapter.obtenerNombreQuizSegunPosicion(ultimoSeleccionado));

            startActivity(intent);


        }




    }

    public void addQuiz(View view) {


        nuevo.startAnimation(touch);

        Intent intent = new Intent(this, nuevoQuiz.class);

        startActivity(intent);

    }
}
