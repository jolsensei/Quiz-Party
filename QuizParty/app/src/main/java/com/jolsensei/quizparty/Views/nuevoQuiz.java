package com.jolsensei.quizparty.Views;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.Views.Fragments.botones;
import com.jolsensei.quizparty.Views.Fragments.inputNuevoQuiz;

public class nuevoQuiz extends AppCompatActivity {


    FrameLayout nuevoQuizContainer;
    TextView iconoGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_quiz);


        nuevoQuizContainer = findViewById(R.id.nuevoQuizContainer);

        iconoGuardar = findViewById(R.id.iconoGuardarNuevo);


        inputNuevoQuiz nuevoQuiz = new inputNuevoQuiz();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.nuevoQuizContainer, nuevoQuiz, "nuevoQuiz");
        transaction.commit();
    }



    public void guardarQuiz(View view) {

        FragmentManager fm = getSupportFragmentManager();

        inputNuevoQuiz fragment = (inputNuevoQuiz) fm.findFragmentByTag("nuevoQuiz");

        if(fragment.guardarQuiz()){

            finish();

        }

    }
}
