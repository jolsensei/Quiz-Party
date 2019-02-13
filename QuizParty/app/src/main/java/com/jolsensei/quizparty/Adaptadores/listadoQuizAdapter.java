package com.jolsensei.quizparty.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.difficulties;
import com.jolsensei.quizparty.R;

import java.util.ArrayList;

public class listadoQuizAdapter extends RecyclerView.Adapter<listadoQuizAdapter.QuizViewHolder> {

    private ArrayList<Quiz> listadoQuiz;
    private final listadoQuizAdapterOnClickHandler listadoQuizHandler;
    private Repositories repo = new Repositories();
    private Context context;

    public listadoQuizAdapter(listadoQuizAdapterOnClickHandler clickHandler, Context c){

        listadoQuizHandler = clickHandler;

        context = c;

    }


     class QuizViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,
                                                                     View.OnClickListener  {
        CardView cv;
        TextView name;
        TextView easyQuestions;
        TextView hardQuestions;

        QuizViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            cv = (CardView)itemView.findViewById(R.id.cardQuiz);
            name = (TextView)itemView.findViewById(R.id.tituloQuiz);
            easyQuestions = (TextView)itemView.findViewById(R.id.botonFacil);
            hardQuestions = (TextView)itemView.findViewById(R.id.botonDificiles);

        }

         @Override
         public boolean onLongClick(View view) {
             return listadoQuizHandler.onLongClick(getAdapterPosition());
         }

         @Override
         public void onClick(View view) {
             listadoQuizHandler.onClick(getAdapterPosition());
         }

    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.card;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        listadoQuizAdapter.QuizViewHolder viewHolder = new listadoQuizAdapter.QuizViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

        Quiz currentQuiz = listadoQuiz.get(position);

        holder.name.setText(currentQuiz.getName());
        holder.easyQuestions.setText(String.valueOf(repo.countQuestionsByNameAndDifficulty(context, currentQuiz.getName(), difficulties.EASY)));
        holder.hardQuestions.setText(String.valueOf(repo.countQuestionsByNameAndDifficulty(context, currentQuiz.getName(), difficulties.HARD)));


    }

    @Override
    public int getItemCount() {

        return listadoQuiz.size();
    }



    public void setQuizData(ArrayList<Quiz> listado){

        this.listadoQuiz = listado;
        notifyDataSetChanged();
    }


    public void borrar(int posicion, Context c){

        Repositories repo = new Repositories();

        repo.deleteQuiz(c, listadoQuiz.get(posicion));

        this.listadoQuiz.remove(posicion);
        notifyItemRemoved(posicion);





    }


    public String obtenerNombreQuizSegunPosicion(int posicion){


        return listadoQuiz.get(posicion).getName();
    }






}
