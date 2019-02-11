package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;


public class inputEditarQuiz extends Fragment {

    EditText nombre, naranja, verde, marron, azul, rosa, amarillo;
    editarQuizVM miVM;

    public inputEditarQuiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_input_editar_quiz, container, false);

        nombre = view.findViewById(R.id.inputNombreQuizEdit);

        naranja = view.findViewById(R.id.inputDefNaranjaEdit);
        verde = view.findViewById(R.id.inputDefVerdeEdit);
        marron = view.findViewById(R.id.inputDefMarronEdit);
        azul = view.findViewById(R.id.inputDefAzulEdit);
        rosa = view.findViewById(R.id.inputDefRosaEdit);
        amarillo = view.findViewById(R.id.inputDefAmarillaEdit);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        miVM = ViewModelProviders.of(getActivity()).get(editarQuizVM.class);

        nombre.setText(miVM.get_editedQuiz().getValue().getName());

        naranja.setText(miVM.get_editedQuiz().getValue().getOrangeDef());
        verde.setText(miVM.get_editedQuiz().getValue().getGreenDef());
        marron.setText(miVM.get_editedQuiz().getValue().getBrownDef());
        azul.setText(miVM.get_editedQuiz().getValue().getBlueDef());
        rosa.setText(miVM.get_editedQuiz().getValue().getPinkDef());
        amarillo.setText(miVM.get_editedQuiz().getValue().getYellowDef());
    }

    public boolean guardarQuiz() {

        Repositories repo = new Repositories();

        boolean insertado = false;

        Quiz nuevoQuiz = new Quiz(nombre.getText().toString(), naranja.getText().toString(),
                verde.getText().toString(), azul.getText().toString(),
                amarillo.getText().toString(), marron.getText().toString(), rosa.getText().toString());


        if (nuevoQuiz.getBlueDef().equals("") || nuevoQuiz.getBrownDef().equals("") || nuevoQuiz.getGreenDef().equals("") || nuevoQuiz.getOrangeDef().equals("")
                || nuevoQuiz.getPinkDef().equals("") || nuevoQuiz.getYellowDef().equals("") || nuevoQuiz.getName().equals("")){

            Toast.makeText(getContext(), "No puede insertar campos vacios", Toast.LENGTH_SHORT).show();

        }else {
            //Actualizar
            //repo.insertQuiz(getContext(), nuevoQuiz);

            insertado = true;

        }

        return insertado;

    }
}
