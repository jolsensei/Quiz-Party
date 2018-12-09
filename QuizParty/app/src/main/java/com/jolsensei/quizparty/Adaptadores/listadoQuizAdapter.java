package com.jolsensei.quizparty.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jolsensei.quizparty.R;

public class listadoQuizAdapter extends RecyclerView.Adapter<listadoQuizAdapter.QuizViewHolder> {



    public static class QuizViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView easyQuestions;
        TextView hardQuestions;

        QuizViewHolder(View itemView) {

            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cardQuiz);
            easyQuestions = (TextView)itemView.findViewById(R.id.numeroFaciles);
            hardQuestions = (TextView)itemView.findViewById(R.id.numeroDificiles);

        }
    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
