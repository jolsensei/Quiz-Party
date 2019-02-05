package com.jolsensei.quizparty.DDBB;


import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.widget.Toast;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;
import java.util.List;

public class Repositories {

    public void insertNewData(Context c){

        //Question q = new Question("¿Cuál es el nombre de la cantante de multiples temas de la saga Fate?","Aimer",colors.BROWN,difficulties.HARD,"Anime y Manga");

        //QuizDatabase.getDatabase(c).quizDao().insertQuestion(q);

        Toast.makeText(c, "Datos insertados con exito", Toast.LENGTH_SHORT).show();

    }


    //QUIZ
    public ArrayList<Quiz> getAllQuiz(Context c){


        List<Quiz> list = QuizDatabase.getDatabase(c).quizDao().getQuizs();


        return  new ArrayList<>(list);
    }

    public Quiz getQuizByName(Context c, String quizName){


        Quiz quiz = QuizDatabase.getDatabase(c).quizDao().getQuizByName(quizName);


        return quiz;
    }

    public void  insertQuiz(Context c, Quiz q){

        try {

            QuizDatabase.getDatabase(c).quizDao().insertQuiz(q);

        }catch (SQLiteConstraintException e){

            Toast.makeText(c, "No puedes insertar un Quiz con el mismo nombre", Toast.LENGTH_SHORT).show();

        }



    }

    public void  deleteQuiz(Context c, Quiz q){

        QuizDatabase.getDatabase(c).quizDao().deleteQuiz(q);

    }


    //QUESTION
    public ArrayList<Question> getQuestionsByQuizNameAndDifficulty(Context c, String quizName, difficulties d){


        List<Question> list = QuizDatabase.getDatabase(c).quizDao().getQuestions(quizName, d);


        return  new ArrayList<>(list);
    }


}
