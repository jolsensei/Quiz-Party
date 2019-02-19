package com.jolsensei.quizparty.Views.Fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;


public class inputEditarQuiz extends Fragment implements View.OnClickListener {

    private EditText naranja, verde, marron, azul, rosa, amarillo;
    private TextView guardar;
    private editarQuizVM miVM;

    Animation touch;

    public inputEditarQuiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_input_editar_quiz, container, false);

        naranja = view.findViewById(R.id.inputDefNaranjaEdit);
        verde = view.findViewById(R.id.inputDefVerdeEdit);
        marron = view.findViewById(R.id.inputDefMarronEdit);
        azul = view.findViewById(R.id.inputDefAzulEdit);
        rosa = view.findViewById(R.id.inputDefRosaEdit);
        amarillo = view.findViewById(R.id.inputDefAmarillaEdit);

        guardar = view.findViewById(R.id.iconoGuardarEditar);

        touch = AnimationUtils.loadAnimation(getContext(), R.anim.touch);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        miVM = ViewModelProviders.of(getActivity()).get(editarQuizVM.class);

        naranja.setText(miVM.get_editedQuiz().getValue().getOrangeDef());
        verde.setText(miVM.get_editedQuiz().getValue().getGreenDef());
        marron.setText(miVM.get_editedQuiz().getValue().getBrownDef());
        azul.setText(miVM.get_editedQuiz().getValue().getBlueDef());
        rosa.setText(miVM.get_editedQuiz().getValue().getPinkDef());
        amarillo.setText(miVM.get_editedQuiz().getValue().getYellowDef());

        guardar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        guardarCambiosQuiz();

    }

    public void guardarCambiosQuiz() {

        guardar.startAnimation(touch);

        Repositories repo = new Repositories();

        Quiz editQuiz = new Quiz(miVM.get_editedQuiz().getValue().getName(), naranja.getText().toString(),
                verde.getText().toString(), azul.getText().toString(),
                amarillo.getText().toString(), marron.getText().toString(), rosa.getText().toString());


        if (editQuiz.getBlueDef().equals("") || editQuiz.getBrownDef().equals("") || editQuiz.getGreenDef().equals("") || editQuiz.getOrangeDef().equals("")
                || editQuiz.getPinkDef().equals("") || editQuiz.getYellowDef().equals("")){


            DynamicToast.makeWarning(getContext(), "No puede insertar campos vacíos").show();

        }else {

            repo.updateQuiz(getContext(), editQuiz);


            DynamicToast.makeSuccess(getContext(), "Actualizado con éxito").show();
        }



    }


}
