package com.jolsensei.quizparty.Generador;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;

public class defaultQuiz {


    public ArrayList<Quiz> defaultQuizGenerator(){

        ArrayList<Quiz> list = new ArrayList<>();

        ArrayList<Question> questionList = new ArrayList<>();

        questionList.add(new Question("¿En que famoso manga/anime aparece la isla de Skypea?","One Piece",colors.GREEN,difficulties.EASY));
        questionList.add(new Question("¿Cual es la duracion media de un capitulo de anime?","20 minutos",colors.ORANGE,difficulties.EASY));
        questionList.add(new Question("¿Como se denominan los mangas dibujados a base de 4 viñetas?","4-koma",colors.BLUE,difficulties.EASY));
        questionList.add(new Question("Cual es el nombre del primer opening de One Piece","We are",colors.BROWN,difficulties.EASY));
        questionList.add(new Question("¿Cual era el equipo al que pertenecian Naruto, Sakura y Sasuke?","7",colors.PINK,difficulties.EASY));
        questionList.add(new Question("¿En Shingeki no Kyojin, poseen aparato reproductor los titanes?","No",colors.YELLOW,difficulties.EASY));

        list.add(new Quiz("Anime y Manga","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionList));
        list.add(new Quiz("Mango y Animu","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionList));
        list.add(new Quiz("Monitos chinos","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionList));
        list.add(new Quiz("Dibujitos Gapón","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionList));
        list.add(new Quiz("Illo que funciona","Anime","Mundo","Manga","Miscelaneo","Musica","Personajes",questionList));

        return list;
    }

}
