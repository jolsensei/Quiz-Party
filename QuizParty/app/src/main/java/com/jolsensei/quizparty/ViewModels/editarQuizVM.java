package com.jolsensei.quizparty.ViewModels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.content.Context;
import androidx.annotation.NonNull;

import com.jolsensei.quizparty.DDBB.Repositories;
import com.jolsensei.quizparty.Entidades.Question;
import com.jolsensei.quizparty.Entidades.Quiz;

import java.util.List;

public class editarQuizVM extends AndroidViewModel{

    private Repositories repo = new Repositories();

    private MutableLiveData<Quiz> _editedQuiz;

    private LiveData<List<Question>> _allQuestions;

    private int _ultimaPosicion;

    private boolean _quieroBorrar;

    public editarQuizVM(@NonNull Application application) {
        super(application);


        _editedQuiz = new MutableLiveData<>();
        _ultimaPosicion = 0;
        _quieroBorrar = false;

        _allQuestions = repo.getQuestionsByQuizName(application.getApplicationContext(), "");
    }


    public MutableLiveData<Quiz> get_editedQuiz() {

        if (_editedQuiz == null){

            _editedQuiz = new MutableLiveData<>();

        }

        return _editedQuiz;
    }

    public int get_ultimaPosicion() {
        return _ultimaPosicion;
    }

    public void set_ultimaPosicion(int _ultimaPosicion) {

        this._ultimaPosicion = _ultimaPosicion;
    }

    public boolean get_quieroBorrar() {
        return _quieroBorrar;
    }

    public void set_quieroBorrar(boolean _quieroBorrar) {

        this._quieroBorrar = _quieroBorrar;
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
