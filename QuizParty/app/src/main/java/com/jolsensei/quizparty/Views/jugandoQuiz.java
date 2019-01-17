package com.jolsensei.quizparty.Views;

import android.support.v4.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProviders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.FrameLayout;
import android.widget.TextView;


import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.difficulties;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;
import com.jolsensei.quizparty.Views.Fragments.botones;
import android.support.v4.app.Fragment;


public class jugandoQuiz extends AppCompatActivity  {

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

        Quiz quiz = getIntent().getExtras().getParcelable("quiz");
        difficulties difficulty = (difficulties) getIntent().getExtras().getSerializable("dificulty");


        miVM.cargarVM(quiz, difficulty);

        currentName.setText(miVM.get_quizEnJuego().getValue().getName());
        currentDifficulty.setText(miVM.get_dificultadSeleccionada().getValue().toString());

        //Añadir el fragment de los botones
        botones addBotones = new botones();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, addBotones);
        transaction.commit();

    }




}
