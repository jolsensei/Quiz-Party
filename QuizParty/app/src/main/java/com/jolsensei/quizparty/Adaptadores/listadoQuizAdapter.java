package com.jolsensei.quizparty.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.R;

import java.util.ArrayList;

public class listadoQuizAdapter extends RecyclerView.Adapter<listadoQuizAdapter.QuizViewHolder> {

    private ArrayList<Quiz> listadoQuiz;


    public static class QuizViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView easyQuestions;
        TextView hardQuestions;

        QuizViewHolder(View itemView) {

            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cardQuiz);
            name = (TextView)itemView.findViewById(R.id.tituloQuiz);
            easyQuestions = (TextView)itemView.findViewById(R.id.numeroFaciles);
            hardQuestions = (TextView)itemView.findViewById(R.id.numeroDificiles);

        }
    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.test;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        QuizViewHolder viewHolder = new QuizViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

        Quiz currentQuiz = listadoQuiz.get(position);

        holder.name.setText(currentQuiz.getName());
        holder.easyQuestions.setText(String.valueOf(currentQuiz.getQuestions().size()));
        holder.hardQuestions.setText(String.valueOf(currentQuiz.getQuestions().size()));


    }

    @Override
    public int getItemCount() {

        return listadoQuiz.size();
    }



    public void setQuizData(ArrayList<Quiz> listado){
        this.listadoQuiz = listado;
        notifyDataSetChanged();
    }






}
