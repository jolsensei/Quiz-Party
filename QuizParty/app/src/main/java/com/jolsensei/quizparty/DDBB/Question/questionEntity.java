package com.jolsensei.quizparty.DDBB.Question;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.ColorInt;

import com.jolsensei.quizparty.DDBB.Quiz.quizEntity;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = quizEntity.class,
        parentColumns = "ID",
        childColumns = "IDQuiz",
        onDelete = CASCADE,
        onUpdate = CASCADE))


public class questionEntity {
    
    @PrimaryKey
    public int IDQuestion;

    @ColumnInfo
    public int IDQuiz;

    @ColumnInfo
    public String question;

    @ColumnInfo
    public String answer;

    @ColumnInfo
    public colors color;

    @ColumnInfo
    public String colorDefinition;

    @ColumnInfo
    public difficulty difficulty;





}
