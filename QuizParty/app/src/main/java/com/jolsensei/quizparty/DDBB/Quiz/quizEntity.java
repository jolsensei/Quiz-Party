package com.jolsensei.quizparty.DDBB.Quiz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class quizEntity {

    
    @PrimaryKey
    public int ID;

    @ColumnInfo
    public String nombreQuiz;



}
