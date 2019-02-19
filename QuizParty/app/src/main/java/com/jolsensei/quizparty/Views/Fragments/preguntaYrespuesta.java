package com.jolsensei.quizparty.Views.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.jugandoQuizVM;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link preguntaYrespuesta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class preguntaYrespuesta extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    TextView definicionColor, preguntaYrespuesta, iconAceptar;

    jugandoQuizVM miVM;

    static boolean front;

    public preguntaYrespuesta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_pregunta_yrespuesta, container, false);


        definicionColor = view.findViewById(R.id.definicionColor);
        preguntaYrespuesta = view.findViewById(R.id.flipPregunta);
        iconAceptar = view.findViewById(R.id.iconoPreguntaResuelta);

        preguntaYrespuesta.setOnClickListener(this);
        iconAceptar.setOnClickListener(this);


        front = true;

        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        miVM = ViewModelProviders.of(getActivity()).get(jugandoQuizVM.class);

        setCurrentQuizDefinitionAndBackgroundColor();

        preguntaYrespuesta.setText(miVM.get_currentQuestion().getValue().getQuestion());


    }


    private void setCurrentQuizDefinitionAndBackgroundColor(){

        switch (miVM.get_currentQuestion().getValue().getColor()){

            case ORANGE:

                definicionColor.setText(miVM.get_quizEnJuego().getValue().getOrangeDef());
                definicionColor.setBackgroundResource(R.drawable.tarjetanaranja);

                break;


            case BLUE:

                definicionColor.setText(miVM.get_quizEnJuego().getValue().getBlueDef());
                definicionColor.setBackgroundResource(R.drawable.tarjetaazul);

                break;

            case PINK:

                definicionColor.setText(miVM.get_quizEnJuego().getValue().getPinkDef());
                definicionColor.setBackgroundResource(R.drawable.tarjetarosa);

                break;

            case BROWN:

                definicionColor.setText(miVM.get_quizEnJuego().getValue().getBrownDef());
                definicionColor.setBackgroundResource(R.drawable.tarjetamarron);

                break;

            case GREEN:

                definicionColor.setText(miVM.get_quizEnJuego().getValue().getGreenDef());
                definicionColor.setBackgroundResource(R.drawable.tarjetaverde);

                break;

            case YELLOW:

                definicionColor.setText(miVM.get_quizEnJuego().getValue().getYellowDef());
                definicionColor.setBackgroundResource(R.drawable.tarjetaamarilla);

                break;
        }


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.flipPregunta:


            final ObjectAnimator oa1 = ObjectAnimator.ofFloat(preguntaYrespuesta, "scaleX", 1f, 0f);
            final ObjectAnimator oa2 = ObjectAnimator.ofFloat(preguntaYrespuesta, "scaleX", 0f, 1f);
            oa1.setInterpolator(new DecelerateInterpolator());
            oa2.setInterpolator(new AccelerateDecelerateInterpolator());
            oa1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);


                    if (front) {

                        preguntaYrespuesta.setText(miVM.get_currentQuestion().getValue().getAnswer());
                        oa2.start();
                        front = false;
                        iconAceptar.setVisibility(View.VISIBLE);

                    } else {

                        preguntaYrespuesta.setText(miVM.get_currentQuestion().getValue().getQuestion());
                        oa2.start();

                        front = true;
                        iconAceptar.setVisibility(View.GONE);

                    }


                }
            });
            oa1.start();

            break;


            case R.id.iconoPreguntaResuelta:


                miVM.get_currentQuestion().postValue(null);

                break;

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
