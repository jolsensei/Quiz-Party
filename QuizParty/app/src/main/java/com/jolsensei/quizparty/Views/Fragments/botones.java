package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;


public class botones extends Fragment implements View.OnClickListener {

    jugandoQuizVM miVM;
    Button botonNaranja, botonVerde, botonMarron, botonAzul, botonRosa, botonAmarillo;


    public botones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_botones, container, false);


        botonNaranja = view.findViewById(R.id.preguntaNaranja);
        botonVerde = view.findViewById(R.id.preguntaVerde);
        botonMarron = view.findViewById(R.id.preguntaMarron);
        botonAzul = view.findViewById(R.id.preguntaAzul);
        botonRosa = view.findViewById(R.id.preguntaRosa);
        botonAmarillo = view.findViewById(R.id.preguntaAmarilla);

        botonNaranja.setOnClickListener(this);
        botonVerde.setOnClickListener(this);
        botonMarron.setOnClickListener(this);
        botonAzul.setOnClickListener(this);
        botonRosa.setOnClickListener(this);
        botonAmarillo.setOnClickListener(this);


        return view;


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        miVM = ViewModelProviders.of(getActivity()).get(jugandoQuizVM.class);

        botonNaranja.append(String.valueOf(miVM.get_orangeQuestions().getValue().size()));
        botonVerde.append(String.valueOf(miVM.get_greenQuestions().getValue().size()));
        botonMarron.append(String.valueOf(miVM.get_browQuestions().getValue().size()));
        botonAzul.append(String.valueOf(miVM.get_blueQuestions().getValue().size()));
        botonRosa.append(String.valueOf(miVM.get_pinkQuestions().getValue().size()));
        botonAmarillo.append(String.valueOf(miVM.get_yellowQuestions().getValue().size()));


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()){

            case R.id.preguntaNaranja:

                Toast.makeText(getContext(), "naranja", Toast.LENGTH_SHORT).show();


                break;


            case R.id.preguntaVerde:

                Toast.makeText(getContext(), "verde", Toast.LENGTH_SHORT).show();

                break;


        }


    }





}
