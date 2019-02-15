package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jolsensei.quizparty.Adaptadores.listadoQuestionAdapter;
import com.jolsensei.quizparty.Adaptadores.listadoQuestionAdapterOnClickHandler;
import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;
import com.jolsensei.quizparty.Views.nuevaPregunta;

import java.util.ArrayList;
import java.util.List;


public class questionList extends Fragment implements listadoQuestionAdapterOnClickHandler {

    private RecyclerView listadoQuestions;
    private editarQuizVM miVM;
    private listadoQuestionAdapter miAdapter;
    Repositories repo = new Repositories();


    public questionList() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_list, container, false);

        listadoQuestions = view.findViewById(R.id.questionList);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        miVM = ViewModelProviders.of(getActivity()).get(editarQuizVM.class);

        listadoQuestions.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        listadoQuestions.setLayoutManager(llm);

        miAdapter = new listadoQuestionAdapter(this, getContext());


        final Observer<List<Question>> questionListObserver = new Observer<List<Question>>() {
            @Override
            public void onChanged(@Nullable final List<Question> newList) {

                if(miVM.get_quieroBorrar()){

                    miAdapter.notifyItemRemoved(miVM.get_ultimaPosicion());

                    miVM.set_quieroBorrar(false);

                }else {

                    ArrayList<Question> listaMomentanea = new ArrayList<>(newList);

                    miAdapter.update(listaMomentanea);

                    listadoQuestions.setAdapter(miAdapter);

                }





            }
        };

        miVM.get_allQuestions().observe(this, questionListObserver);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                miVM.set_quieroBorrar(true);
                miVM.set_ultimaPosicion(viewHolder.getAdapterPosition());

                repo.deleteQuestion(getContext(), miVM.get_allQuestions().getValue().get(viewHolder.getAdapterPosition()));


            }

        }).attachToRecyclerView(listadoQuestions);

    }



    @Override
    public void onClick(int adapterPosition) {


        int idPregunta = miVM.get_allQuestions().getValue().get(adapterPosition).getId();
        String nombreQuiz = miVM.get_allQuestions().getValue().get(adapterPosition).getQuiz_name();

        Intent intent = new Intent(getContext(), nuevaPregunta.class);
        intent.putExtra("idPregunta", idPregunta);
        intent.putExtra("nombreQuiz", nombreQuiz);

        startActivity(intent);

    }
}
