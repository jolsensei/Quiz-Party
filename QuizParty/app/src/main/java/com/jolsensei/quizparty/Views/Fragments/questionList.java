package com.jolsensei.quizparty.Views.Fragments;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
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

                    //miAdapter.notifyItemRemoved(miVM.get_ultimaPosicion());

                    //Hacemos esto por que no queremos cargar la lista a pelo de nuevo

                    miVM.set_quieroBorrar(false);

                }else {

                    ArrayList<Question> listaMomentanea = new ArrayList<>(newList);

                    miAdapter.update(listaMomentanea);

                    listadoQuestions.setAdapter(miAdapter);

                }





            }
        };

        miVM.get_allQuestions().observe(this, questionListObserver);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                miVM.set_quieroBorrar(true);
                miVM.set_ultimaPosicion(viewHolder.getAdapterPosition());

                miAdapter.borrar(miVM.get_ultimaPosicion());
                repo.deleteQuestion(getContext(), miVM.get_allQuestions().getValue().get(miVM.get_ultimaPosicion()));

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
