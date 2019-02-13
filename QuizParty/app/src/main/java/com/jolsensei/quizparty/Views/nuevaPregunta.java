package com.jolsensei.quizparty.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;
import com.jolsensei.quizparty.R;

public class nuevaPregunta extends AppCompatActivity {

    EditText pregunta, respuesta;
    RadioGroup dificultad, color;
    RadioButton facil, dificil, naranja, verde, marron, azul, rosa, amarillo;
    String nombreQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_nueva_pregunta);


        nombreQuiz = getIntent().getStringExtra("nombreQuiz");

        pregunta = findViewById(R.id.nuevaPreguntaQuestion);
        respuesta = findViewById(R.id.nuevaPreguntaAnswer);

        dificultad = findViewById(R.id.radioDificultad);
        color = findViewById(R.id.radioColor);

        facil = findViewById(R.id.radioFacil);
        dificil = findViewById(R.id.radioDificil);

        naranja = findViewById(R.id.radioNaranja);
        verde = findViewById(R.id.radioVerde);
        marron = findViewById(R.id.radioMarron);
        azul = findViewById(R.id.radioAzul);
        rosa = findViewById(R.id.radioRosa);
        amarillo = findViewById(R.id.radioAmarillo);


    }

    public void guardarNuevaPregunta(View view) {

        Repositories repo = new Repositories();

        Question nuevaPregunta;

        difficulties qDificultad = null;
        colors qColor = null;


        switch (dificultad.getCheckedRadioButtonId()){

            case R.id.radioFacil:

                qDificultad = difficulties.EASY;

                break;


            case R.id.radioDificil:

                qDificultad = difficulties.HARD;

                break;


        }


        switch (color.getCheckedRadioButtonId()){

            case R.id.radioNaranja:

                qColor = colors.ORANGE;

                break;


            case R.id.radioVerde:

                qColor = colors.GREEN;

                break;

            case R.id.radioMarron:

                qColor = colors.BROWN;

                break;

            case R.id.radioAzul:

                qColor = colors.BLUE;

                break;


            case R.id.radioRosa:

                qColor = colors.PINK;

                break;

            case R.id.radioAmarillo:

                qColor = colors.YELLOW;

                break;

        }

        nuevaPregunta = new Question(pregunta.getText().toString(), respuesta.getText().toString(), qColor, qDificultad, nombreQuiz);

        if(nuevaPregunta.getQuestion().equals("") || nuevaPregunta.getAnswer().equals("")){

            Toast.makeText(this, "No puedes dejar informacion en blanco", Toast.LENGTH_SHORT).show();

        }else {

            repo.insertNewQuestion(this, nuevaPregunta);

            finish();
        }






    }
}
