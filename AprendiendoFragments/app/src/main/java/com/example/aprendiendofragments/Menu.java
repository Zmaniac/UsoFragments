package com.example.aprendiendofragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendiendofragments.interfaces.ComunicarMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    private final int[] BOTONES={R.id.botonlinterna,R.id.botonmusica,R.id.botonnivelador};


    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mimenu= inflater.inflate(R.layout.fragment_menu, container, false);



        for(int ib:BOTONES){

            final  ImageButton boton;
    boton=(ImageButton) mimenu.findViewById(ib);


    boton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ComunicarMenu a= (ComunicarMenu) getActivity();

            a.menu(boton.getId());

        }
    });

        }

        return mimenu;
    }

}
