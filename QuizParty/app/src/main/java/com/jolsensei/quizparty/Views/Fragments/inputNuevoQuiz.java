package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.ViewModelProviders;
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


public class inputNuevoQuiz extends Fragment{

    EditText nombre, naranja, verde, marron, azul, rosa, amarillo;

    public inputNuevoQuiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nuevo_quiz, container, false);

        nombre = view.findViewById(R.id.inputNombreQuiz);

        naranja = view.findViewById(R.id.inputDefNaranja);
        verde = view.findViewById(R.id.inputDefVerde);
        marron = view.findViewById(R.id.inputDefMarron);
        azul = view.findViewById(R.id.inputDefAzul);
        rosa = view.findViewById(R.id.inputDefRosa);
        amarillo = view.findViewById(R.id.inputDefAmarilla);


        return view;
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

            repo.insertQuiz(getContext(), nuevoQuiz);

            insertado = true;

        }

        return insertado;

    }
}
