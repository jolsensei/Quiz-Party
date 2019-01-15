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
import android.widget.Button;
import android.widget.Toast;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link botones.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class botones extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
