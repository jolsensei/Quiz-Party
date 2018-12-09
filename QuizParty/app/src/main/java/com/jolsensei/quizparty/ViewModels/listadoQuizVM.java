package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jolsensei.quizparty.Entidades.Quiz;
import com.jolsensei.quizparty.Generador.defaultQuiz;

import java.util.ArrayList;

public class listadoQuizVM extends ViewModel {


    private MutableLiveData<ArrayList<Quiz>> _listadoQuiz;


    public listadoQuizVM(){

        defaultQuiz gestora = new defaultQuiz();

        _listadoQuiz.setValue(gestora.defaultQuiz());

    }


    public MutableLiveData<ArrayList<Quiz>> getListadoQuiz() {
        return _listadoQuiz;
    }

    public void setListadoQuiz(MutableLiveData<ArrayList<Quiz>> listadoQuiz) {
        this._listadoQuiz = listadoQuiz;
    }
}
