package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProviders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.difficulties;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;
import com.jolsensei.quizparty.Views.Fragments.botones;
import com.jolsensei.quizparty.Views.Fragments.preguntaYrespuesta;


public class jugandoQuiz extends AppCompatActivity implements preguntaYrespuesta.OnFragmentInteractionListener {

    TextView currentName, currentDifficulty;
    FrameLayout container;

    jugandoQuizVM miVM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugando_quiz);


        miVM = ViewModelProviders.of(this).get(jugandoQuizVM.class);

        container = findViewById(R.id.container);

        currentName = findViewById(R.id.currentQuizName);
        currentDifficulty = findViewById(R.id.currentDifficulty);

        String quizName = getIntent().getStringExtra("quiz");
        difficulties difficulty = (difficulties) getIntent().getExtras().getSerializable("dificulty");


        miVM.cargarVM(quizName, difficulty, this);

        currentName.setText(miVM.get_quizEnJuego().getValue().getName());


        switch (miVM.get_dificultadSeleccionada().getValue()){

            case EASY:

                currentDifficulty.setText(R.string.f_cil);
                currentDifficulty.setTextColor(getResources().getColor(R.color.verdePregunta));

                break;


            case HARD:

                currentDifficulty.setText(R.string.dif_cil);
                currentDifficulty.setTextColor(getResources().getColor(R.color.rosaPregunta));

                break;

        }

        //Añadir el fragment de los botones
        botones addBotones = new botones();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, addBotones);
        transaction.commit();

        final Observer<Question> questionObserver = new Observer<Question>() {
            @Override
            public void onChanged(@Nullable final Question newQuestion) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.appear, R.anim.disspear);

                if(newQuestion != null){

                    preguntaYrespuesta addPyR = new preguntaYrespuesta();

                    transaction.replace(R.id.container, addPyR);
                    transaction.commit();

                }else {

                    botones addbotones = new botones();

                    transaction.replace(R.id.container, addbotones);
                    transaction.commit();


                }

            }
        };

        miVM.get_currentQuestion().observe(this, questionObserver);

    }

    @Override
    public void onBackPressed() {

        if (miVM.get_currentQuestion().getValue() == null){  //Para ver en que fragment esta

            super.onBackPressed();

        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
