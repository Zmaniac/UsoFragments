package com.example.aprendiendofragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendiendofragments.services.ServicioMusica;


/**
 * A simple {@link Fragment} subclass.
 */
public class BocinaF extends Fragment {

private ImageView imagenbocina;
private boolean encendido;
    public BocinaF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_bocina, container, false);

        imagenbocina=v.findViewById(R.id.bocinavista);

        imagenbocina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(encendido){

                    encendido=false;
                    apaganmusica();
                }else{
                    encendido=true;
                    encendermusica();

                }


            }
        });


        return  v;
    }


    public void apaganmusica(){

        imagenbocina.setImageResource(R.drawable.musica);

        Intent i=new Intent(getActivity(), ServicioMusica.class);
        getActivity().stopService(i);


    }

    public  void encendermusica(){

        imagenbocina.setImageResource(R.drawable.musica2);

        Intent i=new Intent(getActivity(), ServicioMusica.class);
        getActivity().startService(i);



    }


}
