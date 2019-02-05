package com.jolsensei.quizparty.DDBB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colorConverter;
import com.jolsensei.quizparty.Entidades.difficultyConverter;


@Database(entities = {Quiz.class, Question.class}, version = 1, exportSchema = false)
@TypeConverters({colorConverter.class, difficultyConverter.class})
public abstract class QuizDatabase extends RoomDatabase {

    public abstract QuizDAO quizDao();

    private static QuizDatabase INSTANCE;

    public static  QuizDatabase getDatabase(final Context context){

        if (INSTANCE == null){
            synchronized (QuizDatabase.class){
                if (INSTANCE == null){

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),QuizDatabase.class, "quiz_database.db")
                            .allowMainThreadQueries().build();
                }

            }

        }

        return INSTANCE;

    }

}

