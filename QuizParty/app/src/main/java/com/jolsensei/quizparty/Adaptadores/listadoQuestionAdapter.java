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
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.R;

import java.util.ArrayList;

public class listadoQuestionAdapter extends RecyclerView.Adapter<listadoQuestionAdapter.QuestionViewHolder> {

    private ArrayList<Question> listadoQuestion;


    public listadoQuestionAdapter(){



    }


     class QuestionViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView question;
        View color;

         QuestionViewHolder(View itemView) {

            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cardQuestion);
            question = (TextView)itemView.findViewById(R.id.tituloPregunta);
            color = itemView.findViewById(R.id.indicadorColor);

        }


    }


    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.questioncard;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        listadoQuestionAdapter.QuestionViewHolder viewHolder = new listadoQuestionAdapter.QuestionViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

        Question currentQuestion = listadoQuestion.get(position);

        holder.question.setText(currentQuestion.getQuestion());


        switch (currentQuestion.getColor()){

            case BLUE:

                holder.color.setBackgroundResource(R.drawable.indicadorazul);

                break;

            case PINK:

                holder.color.setBackgroundResource(R.drawable.indicadorrosa);

                break;

            case GREEN:

                holder.color.setBackgroundResource(R.drawable.indicadorverde);

                break;

            case YELLOW:

                holder.color.setBackgroundResource(R.drawable.indicadoramarillo);

                break;

            case BROWN:

                holder.color.setBackgroundResource(R.drawable.indicadormarron);

                break;

            case ORANGE:

                holder.color.setBackgroundResource(R.drawable.indicadornaranja);

                break;
        }


    }

    @Override
    public int getItemCount() {

        return listadoQuestion.size();
    }



    public void setQuestionData(ArrayList<Question> listado){

        this.listadoQuestion = listado;
        notifyDataSetChanged();
    }


    public void borrar(int posicion, Context c){

        Repositories repo = new Repositories();

        notifyItemRemoved(posicion);

    }





}