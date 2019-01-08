package com.jolsensei.quizparty.Views.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jolsensei.quizparty.R;

public class botonesQuiz extends Fragment {

    private BotonesQuizViewModel mViewModel;

    public static botonesQuiz newInstance() {
        return new botonesQuiz();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.botones_quiz_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BotonesQuizViewModel.class);
        // TODO: Use the ViewModel
    }

}
