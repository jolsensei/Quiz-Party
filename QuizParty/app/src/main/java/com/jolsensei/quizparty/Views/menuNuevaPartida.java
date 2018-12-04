package com.jolsensei.quizparty.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jolsensei.quizparty.R;

public class menuNuevaPartida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nueva_partida);


    }

    public void volverAtras(View view) {

        //Intent intent = new Intent(this, paginaPrincipal.class);

        //startActivity(intent);

        finish();

    }
}
