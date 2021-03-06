package com.jolsensei.quizparty.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;
import com.jolsensei.quizparty.R;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;

public class nuevaPregunta extends AppCompatActivity implements View.OnClickListener {

    EditText pregunta, respuesta;
    TextView deficionColor, botonGuardar;
    RadioGroup dificultad, color;
    RadioButton facil, dificil, naranja, verde, marron, azul, rosa, amarillo;
    String nombreQuiz;

    Animation touch;

    int idPregunta;
    boolean esUpdate;

    Repositories repo = new Repositories();

    Quiz quizActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_nueva_pregunta);

        touch = AnimationUtils.loadAnimation(this, R.anim.touch);

        nombreQuiz = getIntent().getStringExtra("nombreQuiz");
        idPregunta = getIntent().getIntExtra("idPregunta",-1);

        botonGuardar = findViewById(R.id.iconoGuardarQuestion);

        pregunta = findViewById(R.id.nuevaPreguntaQuestion);
        respuesta = findViewById(R.id.nuevaPreguntaAnswer);

        deficionColor = findViewById(R.id.definicionColorQuestionEdit);

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

        naranja.setOnClickListener(this);
        verde.setOnClickListener(this);
        marron.setOnClickListener(this);
        azul.setOnClickListener(this);
        rosa.setOnClickListener(this);
        amarillo.setOnClickListener(this);

        quizActual = repo.getQuizByName(this, nombreQuiz);

        if (idPregunta != -1){

            cargarDatos();
            esUpdate = true;


        }else {

            //Cargar la primera definicion

            deficionColor.setText(quizActual.getOrangeDef());
        }

    }

    private void cargarDatos() {

        Question questionSeleccionada = repo.getQuestionById(this, idPregunta);

        pregunta.setText(questionSeleccionada.getQuestion());
        respuesta.setText(questionSeleccionada.getAnswer());

        switch (questionSeleccionada.getDifficulty()){

            case EASY:

                dificultad.check(R.id.radioFacil);


                break;

            case HARD:

                dificultad.check(R.id.radioDificil);

                break;

        }


        switch (questionSeleccionada.getColor()){

            case ORANGE:

                color.check(R.id.radioNaranja);
                deficionColor.setText(quizActual.getOrangeDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetanaranja);

                break;


            case GREEN:

                color.check(R.id.radioVerde);
                deficionColor.setText(quizActual.getGreenDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetaverde);

                break;


            case BROWN:

                color.check(R.id.radioMarron);
                deficionColor.setText(quizActual.getBrownDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetamarron);

                break;


            case BLUE:

                color.check(R.id.radioAzul);
                deficionColor.setText(quizActual.getBlueDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetaazul);

                break;


            case PINK:

                color.check(R.id.radioRosa);
                deficionColor.setText(quizActual.getPinkDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetarosa);

                break;


            case YELLOW:

                color.check(R.id.radioAmarillo);
                deficionColor.setText(quizActual.getYellowDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetaamarilla);

                break;

        }

    }

    public void guardarNuevaPregunta(View view) {


        Question nuevaPregunta;

        difficulties qDificultad = null;
        colors qColor = null;

        botonGuardar.startAnimation(touch);

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


            DynamicToast.makeWarning(this, "No puede insertar campos vacíos").show();

        }else {

            if (esUpdate){

                nuevaPregunta.setId(idPregunta);
                repo.updateQuestion(this, nuevaPregunta);

                DynamicToast.makeSuccess(this, "Actualizado con éxito").show();

            }else {

                repo.insertNewQuestion(this, nuevaPregunta);

                DynamicToast.makeSuccess(this, "Insertado con éxito").show();
            }


            finish();
        }






    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.radioNaranja:

                deficionColor.setText(quizActual.getOrangeDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetanaranja);

                break;


            case R.id.radioVerde:


                deficionColor.setText(quizActual.getGreenDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetaverde);

                break;


            case R.id.radioMarron:


                deficionColor.setText(quizActual.getBrownDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetamarron);

                break;


            case R.id.radioAzul:


                deficionColor.setText(quizActual.getBlueDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetaazul);

                break;


            case R.id.radioRosa:


                deficionColor.setText(quizActual.getPinkDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetarosa);

                break;


            case R.id.radioAmarillo:


                deficionColor.setText(quizActual.getYellowDef());
                deficionColor.setBackgroundResource(R.drawable.tarjetaamarilla);

                break;

        }


    }
}
