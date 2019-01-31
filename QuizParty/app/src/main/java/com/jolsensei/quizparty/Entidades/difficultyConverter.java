package com.jolsensei.quizparty.Entidades;

import android.arch.persistence.room.TypeConverter;

public class difficultyConverter {


    @TypeConverter
    public String fromEnum(difficulties value) {

        return value.toString();
    }

    @TypeConverter
    public difficulties toEnum(String value) {

        return difficulties.valueOf(value);
    }
}
