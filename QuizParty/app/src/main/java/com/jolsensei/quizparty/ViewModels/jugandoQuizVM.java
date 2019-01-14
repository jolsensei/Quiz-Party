package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;

public class jugandoQuizVM extends ViewModel {

    private MutableLiveData<Quiz> _currentQuiz;
    private MutableLiveData<difficulties> _currentDifficulty;

    private MutableLiveData<ArrayList<Question>> _orangeQuestions;
    private MutableLiveData<ArrayList<Question>> _greenQuestions;
    private MutableLiveData<ArrayList<Question>> _browQuestions;
    private MutableLiveData<ArrayList<Question>> _blueQuestions;
    private MutableLiveData<ArrayList<Question>> _pinkQuestions;
    private MutableLiveData<ArrayList<Question>> _yellowQuestions;




    public MutableLiveData<Quiz> get_quizEnJuego() { return _currentQuiz; }

    public MutableLiveData<difficulties> get_dificultadSeleccionada() {
        return _currentDifficulty;
    }

    public MutableLiveData<ArrayList<Question>> get_orangeQuestions() { return _orangeQuestions; }
    public MutableLiveData<ArrayList<Question>> get_greenQuestions() { return _greenQuestions; }
    public MutableLiveData<ArrayList<Question>> get_browQuestions() { return _browQuestions; }
    public MutableLiveData<ArrayList<Question>> get_blueQuestions() { return _blueQuestions; }
    public MutableLiveData<ArrayList<Question>> get_pinkQuestions() { return _pinkQuestions; }
    public MutableLiveData<ArrayList<Question>> get_yellowQuestions() { return _yellowQuestions; }

    public jugandoQuizVM(){

        _currentQuiz = new MutableLiveData<>();

        _currentDifficulty = new MutableLiveData<>();

        _orangeQuestions = new MutableLiveData<>();
        _greenQuestions = new MutableLiveData<>();
        _browQuestions = new MutableLiveData<>();
        _blueQuestions = new MutableLiveData<>();
        _pinkQuestions = new MutableLiveData<>();
        _yellowQuestions = new MutableLiveData<>();


    }


    public void cargarVM(Quiz quiz, difficulties difficulty){

        _currentQuiz.setValue(quiz);

        _currentDifficulty.setValue(difficulty);

        _orangeQuestions.setValue(quiz.questionFilter(difficulty, colors.ORANGE));
        _greenQuestions.setValue(quiz.questionFilter(difficulty, colors.GREEN));
        _browQuestions.setValue(quiz.questionFilter(difficulty, colors.BROWN));
        _blueQuestions.setValue(quiz.questionFilter(difficulty, colors.BLUE));
        _pinkQuestions.setValue(quiz.questionFilter(difficulty, colors.PINK));
        _yellowQuestions.setValue(quiz.questionFilter(difficulty, colors.YELLOW));




    }


}
