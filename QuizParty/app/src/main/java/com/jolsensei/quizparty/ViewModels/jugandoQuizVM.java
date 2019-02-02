package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Entidades.colors;
import com.jolsensei.quizparty.Entidades.difficulties;

import java.util.ArrayList;
import java.util.Random;

public class jugandoQuizVM extends ViewModel {

    private MutableLiveData<Quiz> _currentQuiz;
    private MutableLiveData<difficulties> _currentDifficulty;


    private MutableLiveData<ArrayList<Question>> _allQuestions;


    private MutableLiveData<ArrayList<Question>> _orangeQuestions;
    private MutableLiveData<ArrayList<Question>> _greenQuestions;
    private MutableLiveData<ArrayList<Question>> _browQuestions;
    private MutableLiveData<ArrayList<Question>> _blueQuestions;
    private MutableLiveData<ArrayList<Question>> _pinkQuestions;
    private MutableLiveData<ArrayList<Question>> _yellowQuestions;

    private MutableLiveData<Question> _currentQuestion;




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

    public MutableLiveData<Question> get_currentQuestion() { return _currentQuestion; }

    public jugandoQuizVM(){

        _currentQuiz = new MutableLiveData<>();

        _allQuestions = new MutableLiveData<>();

        _currentDifficulty = new MutableLiveData<>();

        _orangeQuestions = new MutableLiveData<>();
        _greenQuestions = new MutableLiveData<>();
        _browQuestions = new MutableLiveData<>();
        _blueQuestions = new MutableLiveData<>();
        _pinkQuestions = new MutableLiveData<>();
        _yellowQuestions = new MutableLiveData<>();
        _currentQuestion = new MutableLiveData<>();

    }


    public void cargarVM(String quizName, difficulties difficulty, Context context){

        Repositories repo = new Repositories();

        Quiz quiz = repo.getQuizByName(context, quizName);

        _currentQuiz.setValue(quiz);

        _allQuestions.setValue(repo.getQuestionsByQuizNameAndDifficulty(context, quizName, difficulty));

        _currentDifficulty.setValue(difficulty);

        _orangeQuestions.setValue(questionFilter(colors.ORANGE));
        _greenQuestions.setValue(questionFilter(colors.GREEN));
        _browQuestions.setValue(questionFilter(colors.BROWN));
        _blueQuestions.setValue(questionFilter(colors.BLUE));
        _pinkQuestions.setValue(questionFilter(colors.PINK));
        _yellowQuestions.setValue(questionFilter(colors.YELLOW));

    }

    public Question randomQuestion(ArrayList<Question> questionList){

        Question randomQuestion = null;
        Random random = new Random();
        int posicionAleatoria = 0;
        int max = questionList.size();
        int min = 0;

        if(max != 0){

            posicionAleatoria = random.nextInt(max - min)+ min;

            randomQuestion = questionList.get(posicionAleatoria);
            questionList.remove(posicionAleatoria);


        }



        return randomQuestion;


    }

    private ArrayList<Question> questionFilter(colors c){

        ArrayList<Question> filteredQuiz = new ArrayList<>();


        for (int i = 0; i < _allQuestions.getValue().size(); i++){

            if (_allQuestions.getValue().get(i).getColor().equals(c)){

                filteredQuiz.add(_allQuestions.getValue().get(i));

            }
        }


        return filteredQuiz;
    }






}
