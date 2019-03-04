package com.example.aprendiendofragments.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.aprendiendofragments.R;

public class ServicioMusica extends Service {
MediaPlayer mp;

public void onCreate(){
    super.onCreate();

    mp=MediaPlayer.create(this, R.raw.canciovi);
    mp.setLooping(true);
mp.setVolume(100,100);

    }


    public int onStartCommand(Intent intent,int flags,int startId){

    mp.start();

    return START_STICKY;
    }


    public void  onDestroy(){

    if(mp.isPlaying()){

        mp.stop();
        mp.release();
        mp=null;

    }


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }




}
