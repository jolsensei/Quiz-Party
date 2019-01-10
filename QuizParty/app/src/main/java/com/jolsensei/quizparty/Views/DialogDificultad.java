package com.jolsensei.quizparty.Views;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.jolsensei.quizparty.Entidades.difficulties;
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


    public void seleccionarDificultad(View view) {

        Intent returnIntent = new Intent();

        switch (view.getId()){



            case R.id.botonFacil:

                returnIntent.putExtra("result", difficulties.EASY);
                setResult(Activity.RESULT_OK,returnIntent);

                break;


            case R.id.botonDificiles:

                returnIntent.putExtra("result",difficulties.HARD);
                setResult(Activity.RESULT_OK,returnIntent);

                break;
        }

        finish();

    }
}
