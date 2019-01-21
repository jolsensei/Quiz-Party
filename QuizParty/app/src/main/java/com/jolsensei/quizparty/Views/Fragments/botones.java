package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;


public class botones extends Fragment implements View.OnClickListener {

    jugandoQuizVM miVM;
    Button botonNaranja, botonVerde, botonMarron, botonAzul, botonRosa, botonAmarillo;

    TextView recargar, info, descripcionNaranja, descripcionVerde, descripcionMarron, descripcionAzul, descripcionRosa, descripcionAmarilla;

    private boolean descripcionActiva;


    public botones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_botones, container, false);

        descripcionActiva = false;

        info = view.findViewById(R.id.iconoInfo);

        botonNaranja = view.findViewById(R.id.preguntaNaranja);
        botonVerde = view.findViewById(R.id.preguntaVerde);
        botonMarron = view.findViewById(R.id.preguntaMarron);
        botonAzul = view.findViewById(R.id.preguntaAzul);
        botonRosa = view.findViewById(R.id.preguntaRosa);
        botonAmarillo = view.findViewById(R.id.preguntaAmarilla);

        descripcionNaranja = view.findViewById(R.id.descripcionNaranja);
        descripcionVerde = view.findViewById(R.id.descripcionVerde);
        descripcionMarron = view.findViewById(R.id.descripcionMarron);
        descripcionAzul = view.findViewById(R.id.descripcionAzul);
        descripcionRosa = view.findViewById(R.id.descripcionRosa);
        descripcionAmarilla = view.findViewById(R.id.descripcionAmarilla);


        botonNaranja.setOnClickListener(this);
        botonVerde.setOnClickListener(this);
        botonMarron.setOnClickListener(this);
        botonAzul.setOnClickListener(this);
        botonRosa.setOnClickListener(this);
        botonAmarillo.setOnClickListener(this);
        info.setOnClickListener(this);


        return view;


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        miVM = ViewModelProviders.of(getActivity()).get(jugandoQuizVM.class);


        appendNumberOfQuestions();

    }


    @Override
    public void onClick(View view) {

        Question questionToShow = null;


        switch (view.getId()){

            case R.id.preguntaNaranja:

                questionToShow = miVM.randomQuestion(miVM.get_orangeQuestions().getValue());

                break;


            case R.id.preguntaVerde:

                questionToShow = miVM.randomQuestion(miVM.get_greenQuestions().getValue());

                break;


            case R.id.preguntaAzul:

                questionToShow = miVM.randomQuestion(miVM.get_blueQuestions().getValue());

                break;


            case R.id.preguntaMarron:

                questionToShow = miVM.randomQuestion(miVM.get_browQuestions().getValue());

                break;

            case R.id.preguntaRosa:

                questionToShow = miVM.randomQuestion(miVM.get_pinkQuestions().getValue());

                break;


            case R.id.preguntaAmarilla:

                questionToShow = miVM.randomQuestion(miVM.get_yellowQuestions().getValue());

                break;

            case R.id.iconoInfo:


                showQuestionDescriptions();



                break;

        }

        if (questionToShow != null){

            miVM.get_currentQuestion().postValue(questionToShow);

        }

    }

    private void showQuestionDescriptions(){

        if(descripcionActiva){

            descripcionNaranja.setVisibility(View.GONE);
            descripcionVerde.setVisibility(View.GONE);
            descripcionMarron.setVisibility(View.GONE);
            descripcionAzul.setVisibility(View.GONE);
            descripcionRosa.setVisibility(View.GONE);
            descripcionAmarilla.setVisibility(View.GONE);

            descripcionActiva = false;


        }else{

            descripcionNaranja.setVisibility(View.VISIBLE);
            descripcionVerde.setVisibility(View.VISIBLE);
            descripcionMarron.setVisibility(View.VISIBLE);
            descripcionAzul.setVisibility(View.VISIBLE);
            descripcionRosa.setVisibility(View.VISIBLE);
            descripcionAmarilla.setVisibility(View.VISIBLE);

            descripcionActiva = true;

        }

    }

    private void appendNumberOfQuestions(){


        botonNaranja.append(" ");
        botonNaranja.append(Html.fromHtml("<big><b>"+String.valueOf(miVM.get_orangeQuestions().getValue().size())+"</big></b>"));

        botonVerde.append(" ");
        botonVerde.append(Html.fromHtml("<big><b>"+String.valueOf(miVM.get_greenQuestions().getValue().size())+"</big></b>"));

        botonMarron.append(" ");
        botonMarron.append(Html.fromHtml("<big><b>"+String.valueOf(miVM.get_browQuestions().getValue().size())+"</big></b>"));

        botonAzul.append(" ");
        botonAzul.append(Html.fromHtml("<big><b>"+String.valueOf(miVM.get_blueQuestions().getValue().size())+"</big></b>"));

        botonRosa.append(" ");
        botonRosa.append(Html.fromHtml("<big><b>"+String.valueOf(miVM.get_pinkQuestions().getValue().size())+"</big></b>"));

        botonAmarillo.append(" ");
        botonAmarillo.append(Html.fromHtml("<big><b>"+String.valueOf(miVM.get_yellowQuestions().getValue().size())+"</big></b>"));


        descripcionNaranja.setText(miVM.get_quizEnJuego().getValue().getOrangeDef());
        descripcionVerde.setText(miVM.get_quizEnJuego().getValue().getGreenDef());
        descripcionMarron.setText(miVM.get_quizEnJuego().getValue().getBrownDef());
        descripcionAzul.setText(miVM.get_quizEnJuego().getValue().getBlueDef());
        descripcionRosa.setText(miVM.get_quizEnJuego().getValue().getPinkDef());
        descripcionAmarilla.setText(miVM.get_quizEnJuego().getValue().getYellowDef());

    }





}
