package com.jolsensei.quizparty.AsyncTask;

import android.os.AsyncTask;

import com.jolsensei.quizparty.ViewModels.dadoVM;

import java.util.Random;

public class diceRoll extends AsyncTask<Void, Integer, Integer> {

    private dadoVM miMV;

    public diceRoll(dadoVM miMV){

        this.miMV = miMV;

    }


    @Override
    protected Integer doInBackground(Void... voids) {

        Random random = new Random();
        int caraDado = 0;
        int max = 6;
        int min = 0;


        for (int i = 0; i < 8; i++){ //8

            caraDado = random.nextInt(max - min)+ min;

            publishProgress(caraDado);

            try{
                Thread.sleep(100); //100

            }catch (InterruptedException e){


            }

        }

        return caraDado;
    }

    protected void onProgressUpdate(Integer... progress) {

        miMV.get_diceFace().setValue(progress[0]);

    }

    protected void onPostExecute(Integer result) {

        miMV.get_diceFace().setValue(result);
    }


}
