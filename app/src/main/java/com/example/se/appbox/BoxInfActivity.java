package com.example.se.appbox;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.PhantomReference;

public class BoxInfActivity extends AppCompatActivity {

    private String txt1;
    private String txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_inf);
        getSupportActionBar().hide();

        txt1="Resource: Recurso ";
        txt2="A stock or supply of money, materials, staff, and other assets that can be drawn on by a person or organization in order to function effectively.";


        final TextView txtView = (TextView)findViewById(R.id.text1);
        final TextView txtView2 = (TextView)findViewById(R.id.text2);

        txtView.setText(txt1);
        txtView2.setText(txt2);

        Button uno = (Button)this.findViewById(R.id.button1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.resource);
        uno.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if(mp.isPlaying()) {
                    mp.pause();
                }
                else{
                    mp.start();

                }
            }
        });

        Runnable notification=new Runnable() {
            @Override
            public void run() {
                notifyThis("¿Estás en tu tiempo libre?",":D Es hora de saber cuanto has aprendido durante el día.");
            }
        };

        new Handler().postDelayed(notification,7000);

    }


    public void notifyThis(String title, String message) {
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        b.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.fondo)
                .setTicker("Hora de tu leeción")
                .setContentTitle(title)
                .setContentText(message)
                .setContentInfo("INFO");

        NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, b.build());
    }
}
