package com.jolsensei.quizparty.Generador;

import android.content.Context;

import com.jolsensei.quizparty.DDBB.QuizDatabase;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;
import java.util.List;

public class defaultQuiz {


    public ArrayList<Quiz> defaultQuizGenerator(){

        ArrayList<Quiz> list = new ArrayList<>();

        ArrayList<Question> questionListEasy = new ArrayList<>();
        ArrayList<Question> questionListHard = new ArrayList<>();

        questionListEasy.add(new Question("¿En que famoso manga/anime aparece la isla de Skypea?","One Piece",colors.GREEN,difficulties.EASY));
        questionListEasy.add(new Question("¿Cual es la duracion media de un capitulo de anime?","20 minutos",colors.ORANGE,difficulties.EASY));
        questionListEasy.add(new Question("¿Como se denominan los mangas dibujados a base de 4 viñetas?","4-koma",colors.BLUE,difficulties.EASY));
        questionListEasy.add(new Question("Cual es el nombre del primer opening de One Piece","We are",colors.BROWN,difficulties.EASY));
        questionListEasy.add(new Question("¿Cual era el equipo al que pertenecian Naruto, Sakura y Sasuke?","7",colors.PINK,difficulties.EASY));
        questionListEasy.add(new Question("En Shingeki no Kyojin, ¿poseen aparato reproductor los titanes?","No",colors.YELLOW,difficulties.EASY));
        questionListEasy.add(new Question("Esto es una prueba extra","Si",colors.ORANGE,difficulties.EASY));

        list.add(new Quiz("Anime y Manga","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionListEasy, questionListHard));
        list.add(new Quiz("Mango y Animu","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionListEasy, questionListHard));
        list.add(new Quiz("Monitos chinos","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionListEasy, questionListHard));
        list.add(new Quiz("Dibujitos Gapón","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionListEasy, questionListHard));
        list.add(new Quiz("Illo que funciona","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionListEasy, questionListHard));

        return list;
    }


    public ArrayList<Quiz> prueba(Context c){


        List<Quiz> list;
        ArrayList<Question> questionListEasy = new ArrayList<>();
        ArrayList<Question> questionListHard = new ArrayList<>();

        questionListEasy.add(new Question("¿En que famoso manga/anime aparece la isla de Skypea?","One Piece",colors.GREEN,difficulties.EASY));
        questionListHard.add(new Question("¿Cual es la duracion media de un capitulo de anime?","20 minutos",colors.ORANGE,difficulties.HARD));

        Quiz q = new Quiz("Anime y Manga","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionListEasy, questionListHard);

        QuizDatabase.getDatabase(c).quizDao().insertQuiz(q);

        list = QuizDatabase.getDatabase(c).quizDao().getQuizs();

        return  new ArrayList<>(list);
    }

}
