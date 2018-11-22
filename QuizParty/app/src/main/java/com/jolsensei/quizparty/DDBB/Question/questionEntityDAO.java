package com.jolsensei.quizparty.DDBB.Question;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.List;

@Dao
public interface questionEntityDAO {

    @Query("SELECT * FROM questionEntity")
    List<questionEntity> getAll();


    @Insert
    void insert(questionEntity question);

    @Delete
    void delete(questionEntity question);

}
