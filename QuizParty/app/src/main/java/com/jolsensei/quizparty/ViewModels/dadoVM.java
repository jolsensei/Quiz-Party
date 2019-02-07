package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;

public class dadoVM extends ViewModel  {


    private MutableLiveData<Integer> _diceFace;


    public dadoVM(){

        _diceFace = new MutableLiveData<>();

    }


    public MutableLiveData<Integer> getListadoQuiz() {

        if (_diceFace == null){

            _diceFace = new MutableLiveData<>();

        }


        return _diceFace;
    }





}
