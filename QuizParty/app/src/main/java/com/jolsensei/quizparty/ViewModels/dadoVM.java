package com.jolsensei.quizparty.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.ArrayList;

public class dadoVM extends ViewModel  {


    private MutableLiveData<Integer> _diceFace;
    private MutableLiveData<Integer> _lastDiceFace;


    public dadoVM(){

        _diceFace = new MutableLiveData<>();
        _lastDiceFace = new MutableLiveData<>();

    }


    public MutableLiveData<Integer> get_diceFace() {

        if (_diceFace == null){

            _diceFace = new MutableLiveData<>();

        }


        return _diceFace;
    }

    public MutableLiveData<Integer> get_lastDiceFace() {

        if (_lastDiceFace == null){

            _lastDiceFace = new MutableLiveData<>();

        }

        return _lastDiceFace;

    }
}
