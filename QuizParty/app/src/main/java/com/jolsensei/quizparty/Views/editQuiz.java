package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jolsensei.quizparty.Adaptadores.editQuizAdapter;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;
import com.jolsensei.quizparty.Views.Fragments.botones;
import com.jolsensei.quizparty.Views.Fragments.inputEditarQuiz;
import com.jolsensei.quizparty.Views.Fragments.inputNuevoQuiz;
import com.jolsensei.quizparty.Views.Fragments.questionList;

public class editQuiz extends AppCompatActivity {


    editarQuizVM miVM;
    TextView logoQuizName;
    ViewPager editPager;
    TabLayout editTab;
    editQuizAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_quiz);

        logoQuizName = findViewById(R.id.logoHeaderEditar);
        editPager = findViewById(R.id.editPager);
        editTab = findViewById(R.id.editTabs);


        miVM = ViewModelProviders.of(this).get(editarQuizVM.class);

        String quizName = getIntent().getStringExtra("quiz");


        miVM.cargarVM(quizName, this);


        logoQuizName.setText(miVM.get_editedQuiz().getValue().getName());


        adapter = new editQuizAdapter(getSupportFragmentManager());

        adapter.addFragment(new inputEditarQuiz(), "Quiz");
        adapter.addFragment(new questionList(), "Questions");

        editPager.setAdapter(adapter);
        editTab.setupWithViewPager(editPager);

    }

    public void addNewQuestion(View view) {

        Intent intent = new Intent(this, nuevaPregunta.class);
        intent.putExtra("nombreQuiz", miVM.get_editedQuiz().getValue().getName());

        startActivity(intent);

    }
}
