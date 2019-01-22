package com.jolsensei.quizparty.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jolsensei.quizparty.Entidades.tarjetaMenu;
import com.jolsensei.quizparty.R;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {


    private ArrayList<tarjetaMenu> listaOpciones = new ArrayList<>();

    public MyPagerAdapter(ArrayList<tarjetaMenu> opciones){

        listaOpciones = opciones;

    }


    @Override
    public int getCount() {

        return listaOpciones.size();

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        TextView titulo, icono, descripcion;

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.menuoption, container , false);

        titulo = view.findViewById(R.id.tituloOpcion);
        titulo.setText(listaOpciones.get(position).getNombreOpcion());

        icono = view.findViewById(R.id.iconoOpcion);
        icono.setBackgroundResource(listaOpciones.get(position).getIconoOpcion());


        descripcion = view.findViewById(R.id.descripcionOpcion);
        descripcion.setText(listaOpciones.get(position).getDescripcionOpcion());




//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(container.getContext(), "You clicked: " + page + ". page.", Toast.LENGTH_SHORT).show();
//            }
//        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);

    }
}
