package com.example.aprendiendofragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LinternaF extends Fragment {

    ImageView Linterna;
    boolean encendido=false;


    public LinternaF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment

        View vista= inflater.inflate(R.layout.fragment_linterna2, container, false);

        Linterna= vista.findViewById(R.id.linternavista);
        Linterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ActivityHerramientas ah=(ActivityHerramientas) getActivity();
             if(encendido){
                 encendido=false;
                 Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.linterna);
                 Linterna.setImageBitmap(bmp);


             }else{

                 encendido=true;

                 Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.linterna2);
                 Linterna.setImageBitmap(bmp);



             }

                ah.camara(encendido);


            }
        });


        return vista;

    }

}
