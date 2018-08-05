package com.example.se.appbox;

import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.LinkedList;

public class MainMenuActivity extends AppCompatActivity {

    private Switch switchServicio;


    //preferecias
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;

    //listas Categoria
    private LinkedList listaA,listaB,listaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        edit.putString("1","Im going to walk the dog-0");
        edit.putString("11","Voy a pasear al perro-0");

        edit.putString("2","Back away-0");
        edit.putString("22","Tetroceder-0");

        edit.putString("3","I'm starting to break away from the traditions I was raised in-0");
        edit.putString("33","Estoy comenzando a alejarme de las tradiciones con las que me criaron-0");

        edit.putString("4","The train drew into the station-0");
        edit.putString("44","El tren llegó a la estación-0");

        edit.putString("5","obnoxious-0");
        edit.putString("55","desagradable-0");

        edit.putString("6","obnoxious-0");
        edit.putString("66","desagradable-0");

        edit.putString("7","Im going to walk the dog-0");
        edit.putString("77","Voy a pasear al perro-0");

        edit.putString("8","Back away-0");
        edit.putString("88","Tetroceder-0");


        edit.putString("9","I'm starting to break away from the traditions I was raised in-0");
        edit.putString("99","Estoy comenzando a alejarme de las tradiciones con las que me criaron-0");


        edit.putString("10","The train drew into the station-0");
        edit.putString("1010","El tren llegó a la estación-0");

        edit.putString("11","obnoxious-0");
        edit.putString("1111","desagradable-0");

        edit.putString("12","Im going to walk the dog-0");
        edit.putString("1212","Voy a pasear al perro-0");

        edit.putString("13","Back away-0");
        edit.putString("1313","Tetroceder-0");

        edit.putString("14","I'm starting to break away from the traditions I was raised in-0");
        edit.putString("1414","Estoy comenzando a alejarme de las tradiciones con las que me criaron-0");

        edit.putString("15","The train drew into the station-0");
        edit.putString("1515","El tren llegó a la estación-0");

        edit.putString("16","obnoxious-0");
        edit.putString("1616","desagradable-0");

        edit.commit();

        for(int i=0; i<10;i++)
        {
            edit.putString(""+i+"A",prefs.getString(""+i,"c"));
        }



        switchServicio=(Switch) findViewById(R.id.switchServicio);
        switchServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainMenuActivity.this, TimeManagementService.class);
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
        });

    }

    public void warnigndialog()
    {

    }
}
