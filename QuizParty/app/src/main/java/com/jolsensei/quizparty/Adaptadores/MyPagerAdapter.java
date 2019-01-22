package com.jolsensei.quizparty.Adaptadores;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jolsensei.quizparty.R;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {


    private ArrayList<String> listaOpciones = new ArrayList<>();

    public MyPagerAdapter(ArrayList<String> opciones){

        listaOpciones = opciones;

    }


    @Override
    public int getCount() {

        return listaOpciones.size();

    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return o==view;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {

        Button button = new Button(container.getContext());
        button.setBackgroundColor(container.getResources().getColor(R.color.verdePregunta));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setText(listaOpciones.get(position));

        final int page = position;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(container.getContext(), "You clicked: " + page + ". page.", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(button);
        return button;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((Button)object);
    }
}
