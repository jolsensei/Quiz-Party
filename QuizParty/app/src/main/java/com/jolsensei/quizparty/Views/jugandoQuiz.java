package com.jolsensei.quizparty.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.R;

public class jugandoQuiz extends AppCompatActivity {

    TextView currentName, currentDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugando_quiz);


        currentName = findViewById(R.id.currentQuizName);
        currentDifficulty = findViewById(R.id.currentDifficulty);

        Quiz enJuego = getIntent().getExtras().getParcelable("quiz");
        String dificultad = getIntent().getStringExtra("dificulty");


        currentName.setText(enJuego.getName());
        currentDifficulty.setText(dificultad);

    }
}
