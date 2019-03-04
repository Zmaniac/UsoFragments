package com.example.aprendiendofragments;



import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aprendiendofragments.interfaces.ComunicarMenu;

public class ActivityHerramientas extends AppCompatActivity implements ComunicarMenu {

    String camaraid;
    CameraManager camaramanager;
    @Override
    @TargetApi(21)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);

        Bundle extras=this.getIntent().getExtras();

        int botones=extras.getInt("botonpulsado");

        menu(botones);
        camaramanager= (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            camaraid = camaramanager.getCameraIdList()[0];
        }catch (Exception e){

            e.printStackTrace();
        }

    }

@TargetApi(23)
    public void camara(boolean b){

        try {
                camaramanager.setTorchMode(camaraid, b);


        }catch (Exception e){


        }

    }


    @Override
    public void menu(int botonid) {

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ImageButton ibnivelador=findViewById(R.id.botonnivelador);
        ImageButton iblinterna=findViewById(R.id.botonlinterna);
        ImageButton ibbocina=findViewById(R.id.botonmusica);
        Bitmap bmp;

        switch (botonid){

            case R.id.botonlinterna:


                ft.replace(R.id.herramientas,new LinternaF());


                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.linterna2);
                iblinterna.setImageBitmap(bmp);

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.musica);
                ibbocina.setImageBitmap(bmp);

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.nivel);
                ibnivelador.setImageBitmap(bmp);



                break;

            case R.id.botonnivelador:
                ft.replace(R.id.herramientas,new NiveladorF());

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.linterna);
                iblinterna.setImageBitmap(bmp);

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.musica);
                ibbocina.setImageBitmap(bmp);

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.nivel2);
                ibnivelador.setImageBitmap(bmp);



                break;


            case R.id.botonmusica:
                ft.replace(R.id.herramientas,new BocinaF());

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.linterna);
                iblinterna.setImageBitmap(bmp);

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.musica2);
                ibbocina.setImageBitmap(bmp);

                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.nivel);
                ibnivelador.setImageBitmap(bmp);



                break;


        }

        ft.commit();

    }
}
