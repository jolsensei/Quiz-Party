package com.jolsensei.quizparty.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.Views.menuNuevaPartida;

public class paginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pagina_principal);
    }


    public void irAMenuPartidas(View view) {

        Intent intent = new Intent(this, menuNuevaPartida.class);

        startActivity(intent);

    }
}
