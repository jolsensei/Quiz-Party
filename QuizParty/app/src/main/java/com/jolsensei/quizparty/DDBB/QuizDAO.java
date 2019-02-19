package com.jolsensei.quizparty.DDBB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.List;

@Dao
public interface QuizDAO {

    //QUIZ
    @Query("SELECT * FROM Quiz")
    public List<Quiz> getQuizs();

    @Query("SELECT * FROM Quiz WHERE name LIKE :quizName")
    public Quiz getQuizByName(String quizName);

    @Insert(onConflict = OnConflictStrategy.ABORT) //Realmente la tiene por defecto
    public void insertQuiz(Quiz q);

    @Delete
    public void deleteQuiz(Quiz q);

    @Update
    public void updateQuiz(Quiz q);


    //QUESTION
    @Query("SELECT * FROM Question WHERE quiz_name LIKE :quizName AND difficulty LIKE :dificultySelected")
    public List<Question> getQuestions(String quizName, difficulties dificultySelected);

    @Query("SELECT * FROM Question WHERE quiz_name LIKE :quizName")
    public LiveData<List<Question>> getAllQuestions(String quizName);

    @Query("SELECT * FROM Question WHERE id LIKE :id")
    public Question getQuestionById(int id);

    @Insert
    public  void insertQuestion(Question q);

    @Update
    public  void updateQuestion(Question q);

    @Delete
    public  void deleteQuestion(Question q);

    @Query("SELECT COUNT(*) FROM Question WHERE quiz_name LIKE :quizName AND difficulty LIKE :dificultySelected")
    public int countQuestionsByNameAndDifficulty(String quizName, difficulties dificultySelected);
}
