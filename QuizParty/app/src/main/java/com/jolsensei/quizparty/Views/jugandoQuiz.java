package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;
import com.jolsensei.quizparty.Views.Fragments.botones;


public class jugandoQuiz extends AppCompatActivity implements botones.OnFragmentInteractionListener {

    TextView currentName, currentDifficulty;

    jugandoQuizVM miVM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugando_quiz);


        currentName = findViewById(R.id.currentQuizName);
        currentDifficulty = findViewById(R.id.currentDifficulty);

        Quiz quiz = getIntent().getExtras().getParcelable("quiz");
        String difficulty = getIntent().getStringExtra("dificulty");

        currentName.setText(quiz.getName());
        currentDifficulty.setText(difficulty);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
