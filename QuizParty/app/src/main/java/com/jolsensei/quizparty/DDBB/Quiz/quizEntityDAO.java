package com.jolsensei.quizparty.DDBB.Quiz;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jolsensei.quizparty.DDBB.Quiz.quizEntity;

import java.util.List;

@Dao
public interface quizEntityDAO {

    @Query("SELECT * FROM quizEntity")

    List<quizEntity> getAll();


    @Insert
    void insert(quizEntity quiz);

    @Delete
    void delete(quizEntity quiz);

}
