package com.jolsensei.quizparty.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jolsensei.quizparty.Entidades.tarjetaMenu;
import com.jolsensei.quizparty.R;

import java.util.ArrayList;

import static com.jolsensei.quizparty.Views.paginaPrincipal.setupData;

public class MyPagerAdapter extends PagerAdapter {


    private ArrayList<tarjetaMenu> listaOpciones = new ArrayList<>();

    private Context mContext;
    private LayoutInflater mLayoutInflater;



    public MyPagerAdapter(final Context context){

        listaOpciones.add(new tarjetaMenu("JUGAR", R.drawable.iconojugar, "¡Reune a tus amigos y disfruta!"));
        listaOpciones.add(new tarjetaMenu("CONTACTO", R.drawable.reportbug, "Reporta errores y contribuye a mejorar la aplicacion"));
        listaOpciones.add(new tarjetaMenu("WEB MARKET", R.drawable.market, "Descarga contenido creado por otros usuarios"));

        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);


    }


    @Override
    public int getCount() {

        return listaOpciones.size();

    }

    @Override
    public int getItemPosition(final Object object) {

        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        final View view;

        view = mLayoutInflater.inflate(R.layout.menuoption, container , false);

        setupData(view, listaOpciones.get(position));






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
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull final ViewGroup container, int position, @NonNull final Object object) {

        container.removeView((View)object);

    }
}
