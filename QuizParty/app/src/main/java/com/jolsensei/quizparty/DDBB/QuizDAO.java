package com.jolsensei.quizparty.DDBB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;

@Dao
public interface QuizDAO {

    @Query("SELECT * FROM Quiz")
    public ArrayList<Quiz> getQuizs();


    @Query("SELECT * FROM Question WHERE quiz_name LIKE :quizName")
    public ArrayList<Question> getQuestions(String quizName);

}
