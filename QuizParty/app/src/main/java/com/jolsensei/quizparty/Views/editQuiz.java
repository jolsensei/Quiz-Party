package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jolsensei.quizparty.Adaptadores.editQuizAdapter;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;
import com.jolsensei.quizparty.Views.Fragments.botones;
import com.jolsensei.quizparty.Views.Fragments.inputEditarQuiz;
import com.jolsensei.quizparty.Views.Fragments.inputNuevoQuiz;

public class editQuiz extends AppCompatActivity {


    editarQuizVM miVM;
    TextView logoQuizName;
    ViewPager editPager;
    TabLayout editTab;


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


        editQuizAdapter adapter = new editQuizAdapter(getSupportFragmentManager());

        adapter.addFragment(new inputEditarQuiz(), "Quiz");
        adapter.addFragment(new inputNuevoQuiz(), "Questions");

        editPager.setAdapter(adapter);
        editTab.setupWithViewPager(editPager);

    }



}