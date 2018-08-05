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
