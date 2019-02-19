package com.jolsensei.quizparty.Views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jolsensei.quizparty.AsyncTask.diceRoll;
import com.jolsensei.quizparty.R;
import com.jolsensei.quizparty.ViewModels.dadoVM;

public class diceTable extends AppCompatActivity {

    View dado;
    dadoVM miVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_dice_table);


        miVM = ViewModelProviders.of(this).get(dadoVM.class);

        dado = findViewById(R.id.dado);


        final Observer<Integer> diceObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer newNumber) {

                pintarDado(newNumber);
            }
        };

        miVM.get_diceFace().observe(this, diceObserver);


    }


    public void tirarDado(View view) {


        new diceRoll(miVM).execute();

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



    }
}
