package com.jolsensei.quizparty.Adaptadores;

import android.content.Context;
import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jolsensei.quizparty.Entidades.tarjetaMenu;
import com.jolsensei.quizparty.R;
import com.tiagosantos.enchantedviewpager.EnchantedViewPager;
import com.tiagosantos.enchantedviewpager.EnchantedViewPagerAdapter;

import java.util.ArrayList;

import static com.jolsensei.quizparty.Views.paginaPrincipal.execOption;
import static com.jolsensei.quizparty.Views.paginaPrincipal.setupData;

public class MyPagerAdapter extends EnchantedViewPagerAdapter {


    private ArrayList<tarjetaMenu> listaOpciones = new ArrayList<>();

    private Context mContext;
    private LayoutInflater mLayoutInflater;



    public MyPagerAdapter(final Context context, ArrayList<tarjetaMenu> listaOpciones){

        super(listaOpciones);

        this.listaOpciones = listaOpciones;

        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);


    }


//    @Override
//    public int getCount() {
//
//        return listaOpciones.size();
//
//    }

    @Override
    public int getItemPosition(final Object object) {

        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        final View view;

        final int itemPosition = position % listaOpciones.size();

        view = mLayoutInflater.inflate(R.layout.menuoption, container , false);


        setupData(view, listaOpciones.get(itemPosition));



        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                execOption(view, listaOpciones.get(itemPosition).getIconoOpcion());
            }
        });

        view.setTag(EnchantedViewPager.ENCHANTED_VIEWPAGER_POSITION + position); //Dice que es necesario
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
