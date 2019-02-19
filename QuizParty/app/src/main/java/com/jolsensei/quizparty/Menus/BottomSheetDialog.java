package com.jolsensei.quizparty.Menus;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jolsensei.quizparty.Entidades.opcionMenu;
import com.jolsensei.quizparty.R;


public class BottomSheetDialog extends BottomSheetDialogFragment{
    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button button1 = v.findViewById(R.id.botonEditarModal);
        Button button2 = v.findViewById(R.id.botonBorrarModal);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked(opcionMenu.EDITAR);
                dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onButtonClicked(opcionMenu.BORRAR);
                dismiss();
            }
        });

        return v;
    }

    public interface BottomSheetListener {

        void onButtonClicked(opcionMenu opcion);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {

            mListener = (BottomSheetListener) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }
}
