package com.askle.askle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by i.m.r l on 02/11/2017.
 */

public class SplashScreen extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashcreen);


        Thread timeThread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timeThread.start();

        /*
        //ler o arquivo para mostrar a tela de escolha inicial apenas uma vez
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
        if(settings.getString("PrefUsuario","").length() > 0){
            //activity pra abrir aqui

        }else {
            Thread timeThread = new Thread(){
                @Override
                public void run(){
                    try{
                        sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            };
            timeThread.start();
        }

/*        Thread timeThread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this, TelaEscolhaInicial.class);
                    startActivity(intent);
                }
            }
        };
        timeThread.start();
    */
    }
    @Override
    public void onPause(){
        super.onPause();
        finish();
    }
}