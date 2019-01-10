package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;

public class jugandoQuizVM extends ViewModel {

    private MutableLiveData<Quiz> _currentQuiz;
    private MutableLiveData<difficulties> _currentDifficulty;

    public MutableLiveData<Quiz> get_quizEnJuego() { return _currentQuiz; }

    public MutableLiveData<difficulties> get_dificultadSeleccionada() {
        return _currentDifficulty;
    }



    public jugandoQuizVM(){

        _currentQuiz = new MutableLiveData<>();

        _currentDifficulty = new MutableLiveData<>();


    }


    public void cargarVM(Quiz quiz, difficulties difficulty){

        _currentQuiz.setValue(quiz);

        _currentDifficulty.setValue(difficulty);


    }


}
