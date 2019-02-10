package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;

public class editarQuizVM extends ViewModel {

    private MutableLiveData<Quiz> _editedQuiz;

    public editarQuizVM(){

        _editedQuiz = new MutableLiveData<>();

    }

    public MutableLiveData<Quiz> get_editedQuiz() {

        if (_editedQuiz == null){

            _editedQuiz = new MutableLiveData<>();

        }

        return _editedQuiz;
    }


    public void cargarVM(String quizName, Context c){

        Repositories repo = new Repositories();

        Quiz quiz = repo.getQuizByName(c, quizName);

        _editedQuiz.setValue(quiz);


    }



}
