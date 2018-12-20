package com.jolsensei.quizparty.Views;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.transition.Explode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.jolsensei.quizparty.R;

public class DialogDificultad extends AppCompatActivity {

    ConstraintLayout layout;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_dialog_dificultad);


        layout = findViewById(R.id.layoutDD);


    }

    @Override
    public void onBackPressed() {

//        Context context = this;
//
//
//
//        layout.animate().translationY(0);
//        layout.setVisibility(View.VISIBLE);
//        Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.dissapear);
//        layout.startAnimation(slideUp);

        super.onBackPressed();
    }

    @Override
    protected void onPause() {

        Context context = this;



        layout.animate().translationY(0);
        layout.setVisibility(View.VISIBLE);
        Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        layout.startAnimation(slideUp);


        super.onPause();
    }
}
