package com.jolsensei.quizparty.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;
import java.util.List;

public class editarQuizVM extends AndroidViewModel{

    private Repositories repo = new Repositories();

    private MutableLiveData<Quiz> _editedQuiz;

    private LiveData<List<Question>> _allQuestions;

    public editarQuizVM(@NonNull Application application) {
        super(application);


        _editedQuiz = new MutableLiveData<>();

        _allQuestions = repo.getQuestionsByQuizName(application.getApplicationContext(), "");
    }


    public MutableLiveData<Quiz> get_editedQuiz() {

        if (_editedQuiz == null){

            _editedQuiz = new MutableLiveData<>();

        }

        return _editedQuiz;
    }

    public LiveData<List<Question>> get_allQuestions() {


        return _allQuestions;
    }


    public void cargarVM(String quizName, Context c){


        Quiz quiz = repo.getQuizByName(c, quizName);

        _editedQuiz.setValue(quiz);

        _allQuestions = repo.getQuestionsByQuizName(c, quizName);

    }



}
