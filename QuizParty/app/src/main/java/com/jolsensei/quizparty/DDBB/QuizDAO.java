package com.jolsensei.quizparty.DDBB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface QuizDAO {

    //QUIZ
    @Query("SELECT * FROM Quiz")
    public List<Quiz> getQuizs();

    @Query("SELECT * FROM Quiz WHERE name LIKE :quizName")
    public Quiz getQuizByName(String quizName);

    @Insert(onConflict = OnConflictStrategy.ABORT) //Realmente la tiene por defecto
    public  void insertQuiz(Quiz q);

    @Delete
    public  void deleteQuiz(Quiz q);


    //QUESTION
    @Query("SELECT * FROM Question WHERE quiz_name LIKE :quizName AND difficulty LIKE :dificultySelected")
    public List<Question> getQuestions(String quizName, difficulties dificultySelected);

    @Insert
    public  void insertQuestion(Question q);
}