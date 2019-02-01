package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Generador.defaultQuiz;

import java.util.ArrayList;
import java.util.List;

public class listadoQuizVM extends ViewModel  {


    private MutableLiveData<ArrayList<Quiz>> _listadoQuiz;


    public listadoQuizVM(){


        _listadoQuiz = new MutableLiveData<>();


    }


    public MutableLiveData<ArrayList<Quiz>> getListadoQuiz() {

        return _listadoQuiz;
    }




}
