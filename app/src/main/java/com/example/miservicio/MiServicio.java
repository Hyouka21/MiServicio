package com.example.miservicio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

class MiServicioextends extends Service {
    private Thread hilo;
    private int contador = 0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        iniciarHilo();
        hilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hilo.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }
    public void iniciarHilo(){
        hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (true) {
                        Log.d("Contador","numero : " + contador);
                        contador++;
                        Thread.sleep(5000);
                    }

                }catch (Exception ex){

                }
            }
        });
    }
}
