package com.example.se.appbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

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





    }
}
