package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;

public class editarQuizVM extends ViewModel {

    private MutableLiveData<Quiz> _editedQuiz;

    private MutableLiveData<ArrayList<Question>> _allQuestions;

    private MutableLiveData<Boolean> _wantToSave;

    public editarQuizVM(){

        _editedQuiz = new MutableLiveData<>();
        _allQuestions = new MutableLiveData<>();
        _wantToSave = new MutableLiveData<>();

    }

    public MutableLiveData<Quiz> get_editedQuiz() {

        if (_editedQuiz == null){

            _editedQuiz = new MutableLiveData<>();

        }

        return _editedQuiz;
    }

    public MutableLiveData<ArrayList<Question>> get_allQuestions() {

        if (_allQuestions == null){

            _allQuestions = new MutableLiveData<>();

        }

        return _allQuestions;
    }

    public MutableLiveData<Boolean> get_wantToSave() {

        if (_wantToSave == null){

            _wantToSave = new MutableLiveData<>();

        }

        return _wantToSave;
    }


    public void cargarVM(String quizName, Context c){

        Repositories repo = new Repositories();

        Quiz quiz = repo.getQuizByName(c, quizName);

        _editedQuiz.setValue(quiz);

        _allQuestions.setValue(repo.getQuestionsByQuizName(c, quizName));


    }



}
