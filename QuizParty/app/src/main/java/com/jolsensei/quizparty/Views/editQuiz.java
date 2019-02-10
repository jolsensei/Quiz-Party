package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;

public class editQuiz extends AppCompatActivity {


    editarQuizVM miVM;
    TextView logoQuizName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_quiz);

        logoQuizName = findViewById(R.id.logoHeaderEditar);


        miVM = ViewModelProviders.of(this).get(editarQuizVM.class);


        String quizName = getIntent().getStringExtra("quiz");


        miVM.cargarVM(quizName, this);


        logoQuizName.setText(miVM.get_editedQuiz().getValue().getName());





    }
}
