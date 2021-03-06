package com.jolsensei.quizparty.DDBB;


import androidx.lifecycle.LiveData;
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

        Question q = new Question("¿Qué famosa cantante ha hecho la mayoria openings de la saga Fate?","Aimer",colors.GREEN,difficulties.HARD,"Prueba");

        QuizDatabase.getDatabase(c).quizDao().insertQuestion(q);

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

    public void updateQuiz(Context c, Quiz q){

        QuizDatabase.getDatabase(c).quizDao().updateQuiz(q);

    }


    //QUESTION
    public ArrayList<Question> getQuestionsByQuizNameAndDifficulty(Context c, String quizName, difficulties d){


        List<Question> list = QuizDatabase.getDatabase(c).quizDao().getQuestions(quizName, d);


        return  new ArrayList<>(list);
    }

    public LiveData<List<Question>> getQuestionsByQuizName(Context c, String quizName){


        return  QuizDatabase.getDatabase(c).quizDao().getAllQuestions(quizName);
    }

    public void insertNewQuestion(Context c, Question q){

        QuizDatabase.getDatabase(c).quizDao().insertQuestion(q);
    }

    public void updateQuestion(Context c, Question q){

        QuizDatabase.getDatabase(c).quizDao().updateQuestion(q);
    }

    public void deleteQuestion(Context c, Question q){

        QuizDatabase.getDatabase(c).quizDao().deleteQuestion(q);
    }


    public Question getQuestionById(Context c, int id){

        return  QuizDatabase.getDatabase(c).quizDao().getQuestionById(id);

    }

    public int countQuestionsByNameAndDifficulty(Context c, String quizName, difficulties d){


        return QuizDatabase.getDatabase(c).quizDao().countQuestionsByNameAndDifficulty(quizName, d);

    }


}
