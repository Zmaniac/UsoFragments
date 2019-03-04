package com.example.aprendiendofragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aprendiendofragments.interfaces.ComunicarMenu;

public class MainActivity extends AppCompatActivity  implements ComunicarMenu {

    @Override
    public void menu(int botonid) {

        Intent i=new Intent(this,ActivityHerramientas.class);

        i.putExtra("botonpulsado",botonid);


        this.startActivity(i);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }
}
