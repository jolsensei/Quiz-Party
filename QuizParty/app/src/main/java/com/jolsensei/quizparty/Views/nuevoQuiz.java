package com.jolsensei.quizparty.Views;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.Views.Fragments.inputNuevoQuiz;

public class nuevoQuiz extends AppCompatActivity {


    FrameLayout nuevoQuizContainer;
    TextView iconoGuardar;

    Animation touch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_quiz);

        touch = AnimationUtils.loadAnimation(this, R.anim.touch);

        nuevoQuizContainer = findViewById(R.id.nuevoQuizContainer);

        iconoGuardar = findViewById(R.id.iconoGuardarNuevo);


        inputNuevoQuiz nuevoQuiz = new inputNuevoQuiz();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.nuevoQuizContainer, nuevoQuiz, "nuevoQuiz");
        transaction.commit();
    }



    public void guardarQuiz(View view) {

        iconoGuardar.startAnimation(touch);

        FragmentManager fm = getSupportFragmentManager();

        inputNuevoQuiz fragment = (inputNuevoQuiz) fm.findFragmentByTag("nuevoQuiz");

        if(fragment.guardarQuiz()){

            finish();

        }

    }
}
