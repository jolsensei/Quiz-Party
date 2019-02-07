package com.jolsensei.quizparty.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.dadoVM;
import com.jolsensei.quizparty.ViewModels.listadoQuizVM;

import java.util.Random;

public class diceTable extends AppCompatActivity {

    View dado;
    dadoVM miVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_table);


        miVM = ViewModelProviders.of(this).get(dadoVM.class);

        dado = findViewById(R.id.dado);

    }


    public void tirarDado(View view) {

        Handler handler = new Handler();

        Random random = new Random();
        int vueltas = 0;
        int caraDado = 0;
        int max = 6;
        int min = 0;

        //vueltas = random.nextInt(max - min)+ min;

        for (int i = 0; i < 10; i++){

            caraDado = random.nextInt(max - min)+ min;

            pintarDado(caraDado);

        }

    }

    private void pintarDado(int caraDado) {



        switch (caraDado){

            case 0:

                dado.setBackgroundResource(R.drawable.d1);

                break;

            case 1:

                dado.setBackgroundResource(R.drawable.d2);

                break;

            case 2:

                dado.setBackgroundResource(R.drawable.d3);

                break;

            case 3:

                dado.setBackgroundResource(R.drawable.d4);

                break;

            case 4:

                dado.setBackgroundResource(R.drawable.d5);

                break;

            case 5:

                dado.setBackgroundResource(R.drawable.d6);

                break;
        }

        dado.refreshDrawableState();

        try {

            Thread.sleep(200);

        }catch (InterruptedException e){


        }







    }
}
