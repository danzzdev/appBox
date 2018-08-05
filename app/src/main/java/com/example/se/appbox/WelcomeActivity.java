package com.example.se.appbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

public class WelcomeActivity extends AppCompatActivity {

    private Switch switchServicio,switchLock;
    private Button button1,button2,button3,button4;


    //pref
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();

        switchServicio=(Switch) findViewById(R.id.switchServicio);
        switchLock=(Switch) findViewById(R.id.switchLock);

        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        edit.putString("A1","Im going to walk the dog");
        edit.putString("B1","Voy a pasear al perro");

        edit.putString("A2","Back away");
        edit.putString("B2","Retroceder");

        edit.putString("A3","I'm starting to break away from the traditions I was raised in");
        edit.putString("B3","Estoy comenzando a alejarme de las tradiciones con las que me criaron");

        edit.putString("A4","The train drew into the station");
        edit.putString("B4","El tren llegó a la estación");

        edit.putString("A5","obnoxious");
        edit.putString("B5","desagradable");

        edit.putString("A6","obnoxious");
        edit.putString("B6","desagradable");

        edit.putString("A7","Im going to walk the dog");
        edit.putString("B7","Voy a pasear al perro");

        edit.putString("A8","Back away");
        edit.putString("B8","Tetroceder");


        edit.putString("A9","I'm starting to break away from the traditions I was raised in");
        edit.putString("B9","Estoy comenzando a alejarme de las tradiciones con las que me criaron");


        edit.putString("A10","The train drew into the station");
        edit.putString("B10","El tren llegó a la estación");

        edit.putString("A11","obnoxious");
        edit.putString("B11","desagradable");

        edit.putString("A12","Im going to walk the dog");
        edit.putString("B12","Voy a pasear al perro");

        edit.putString("A13","Back away");
        edit.putString("B13","Tetroceder");

        edit.putString("A14","I'm starting to break away from the traditions I was raised in");
        edit.putString("B14","Estoy comenzando a alejarme de las tradiciones con las que me criaron");

        edit.putString("A15","The train drew into the station");
        edit.putString("B15","El tren llegó a la estación");

        edit.putString("A16","obnoxious");
        edit.putString("B16","desagradable");

        edit.commit();


        switchServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchServicio.isChecked())
                {
                    Intent intent= new Intent(WelcomeActivity.this, TimeManagementService.class);
                    if(Build.VERSION.SDK_INT>=23) {
                        if(Settings.canDrawOverlays(getApplicationContext()))
                        {
                            warnigndialog();
                            startService(intent);
                        }
                        else
                        {
                            startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
                        }
                    }
                    else
                    {
                        warnigndialog();
                        startService(intent);
                    }
                }
                else
                {
                    switchLock.setChecked(false);
                }
            }
        });

        switchLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchServicio.isChecked())
                {
                    edit.putBoolean("LOCK",switchLock.isChecked());
                    edit.commit();
                }
                else
                {
                    switchLock.setChecked(false);
                }

            }
        });


        button1 = (Button) findViewById(R.id.buttonEasy);
        button1.setEnabled(false);
        button2 = (Button) findViewById(R.id.buttonMedium);
        button2.setEnabled(true);
        button3 = (Button) findViewById(R.id.buttonHard);
        button3.setEnabled(true);

        final Button button4 = (Button) findViewById(R.id.buttonEntrenar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             button1.setEnabled(false);
             button2.setEnabled(true);
             button3.setEnabled(true);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setEnabled(true);
                button2.setEnabled(false);
                button3.setEnabled(true);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(false);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(WelcomeActivity.this, ExamActivity.class);
                startActivity(myIntent);
            }
        });



    }



    public void warnigndialog()
    {

    }
}
