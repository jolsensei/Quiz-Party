package com.jolsensei.quizparty.DDBB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jolsensei.quizparty.DDBB.Quiz.quizEntity;

@Database(entities = {quizEntity.class, quizEntity.class}, version = 1)

public abstract class quizRoomDatabase extends RoomDatabase {


    public  abstract quizEntity quizEntity();


    private static volatile quizRoomDatabase INSTANCE;


    static quizRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (quizRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            quizRoomDatabase.class, "quiz_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
