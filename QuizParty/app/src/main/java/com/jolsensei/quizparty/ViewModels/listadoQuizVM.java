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

        defaultQuiz gestora = new defaultQuiz();

        _listadoQuiz = new MutableLiveData<ArrayList<Quiz>>();

        _listadoQuiz.setValue(gestora.defaultQuizGenerator());

    }


    public MutableLiveData<ArrayList<Quiz>> getListadoQuiz() {

        return _listadoQuiz;
    }

    public void setListadoQuiz(MutableLiveData<ArrayList<Quiz>> listadoQuiz) {

        this._listadoQuiz = listadoQuiz;

    }

    public void borrarQuiz(int posicion){

        ArrayList<Quiz> nuevo = _listadoQuiz.getValue();



        try {
            nuevo.remove(posicion);

            _listadoQuiz.setValue(nuevo);



        }catch (NullPointerException e){

            e.printStackTrace();

        }


    }


}
