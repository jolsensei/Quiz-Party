package com.jolsensei.quizparty.Views;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.jolsensei.quizparty.Adaptadores.editQuizAdapter;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;
import com.jolsensei.quizparty.Views.Fragments.inputEditarQuiz;
import com.jolsensei.quizparty.Views.Fragments.questionList;

public class editQuiz extends AppCompatActivity {


    editarQuizVM miVM;
    TextView logoQuizName, botonNuevo;
    ViewPager editPager;
    TabLayout editTab;
    editQuizAdapter adapter;

    Animation touch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_quiz);

        touch = AnimationUtils.loadAnimation(this, R.anim.touch);

        logoQuizName = findViewById(R.id.logoHeaderEditar);
        editPager = findViewById(R.id.editPager);
        editTab = findViewById(R.id.editTabs);

        botonNuevo = findViewById(R.id.addQuestionIcon);


        miVM = ViewModelProviders.of(this).get(editarQuizVM.class);

        String quizName = getIntent().getStringExtra("quiz");


        adapter = new editQuizAdapter(getSupportFragmentManager());

        adapter.addFragment(new questionList(), "Questions");
        adapter.addFragment(new inputEditarQuiz(), "Quiz");


        editPager.setAdapter(adapter);
        editTab.setupWithViewPager(editPager);

        miVM.cargarVM(quizName, this);

        logoQuizName.setText(miVM.get_editedQuiz().getValue().getName());

    }

    public void addNewQuestion(View view) {

        botonNuevo.startAnimation(touch);

        Intent intent = new Intent(this, nuevaPregunta.class);
        intent.putExtra("nombreQuiz", miVM.get_editedQuiz().getValue().getName());

        startActivity(intent);

    }
}
