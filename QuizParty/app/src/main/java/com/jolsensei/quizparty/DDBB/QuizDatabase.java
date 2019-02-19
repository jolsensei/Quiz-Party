package com.jolsensei.quizparty.DDBB;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
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


