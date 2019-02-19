package com.jolsensei.quizparty.Entidades;

import androidx.room.TypeConverter;

public class colorConverter {


    @TypeConverter
    public String fromEnum(colors value) {

        return value.toString();
    }

    @TypeConverter
    public colors toEnum(String value) {

        return colors.valueOf(value);
    }
}
