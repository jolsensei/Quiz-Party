package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jolsensei.quizparty.Adaptadores.listadoQuestionAdapter;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.editarQuizVM;


public class questionList extends Fragment {

    private RecyclerView listadoQuestions;
    private editarQuizVM miVM;
    private listadoQuestionAdapter miAdapter;

    public questionList() {
        // Required empty public constructor
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

        miAdapter = new listadoQuestionAdapter();
        miAdapter.setQuestionData(miVM.get_allQuestions().getValue());

        listadoQuestions.setAdapter(miAdapter);

    }
}
