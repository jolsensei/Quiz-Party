package com.jolsensei.quizparty.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Explode;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

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
