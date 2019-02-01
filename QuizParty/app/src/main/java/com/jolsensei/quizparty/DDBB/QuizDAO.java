package com.jolsensei.quizparty.DDBB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface QuizDAO {

    @Query("SELECT * FROM Quiz")
    public List<Quiz> getQuizs();

    @Insert
    public  void insertQuiz(Quiz q);


    @Query("SELECT * FROM Question WHERE quiz_name LIKE :quizName")
    public List<Question> getQuestions(String quizName);

}
