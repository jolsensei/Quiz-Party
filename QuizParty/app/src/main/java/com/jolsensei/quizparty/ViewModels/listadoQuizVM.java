package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;

public class listadoQuizVM extends ViewModel  {


    private MutableLiveData<ArrayList<Quiz>> _listadoQuiz;


    public listadoQuizVM(){

        _listadoQuiz = new MutableLiveData<>();

    }


    public MutableLiveData<ArrayList<Quiz>> getListadoQuiz() {

        if (_listadoQuiz == null){

            _listadoQuiz = new MutableLiveData<>();

        }


        return _listadoQuiz;
    }

    public void loadQuizs(Context context){

        Repositories repo = new Repositories();

        _listadoQuiz.setValue(repo.getAllQuiz(context));

    }



}
