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

public class MainMenuActivity extends AppCompatActivity {

    private Switch switchServicio;


    //pref
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        edit.putString("1","Im going to walk the dog");
        edit.putString("11","Voy a pasear al perro");

        edit.putString("2","Back away");
        edit.putString("22","Retroceder");

        edit.putString("3","I'm starting to break away from the traditions I was raised in");
        edit.putString("33","Estoy comenzando a alejarme de las tradiciones con las que me criaron");

        edit.putString("4","The train drew into the station.");
        edit.putString("44","El tren llegó a la estación");

        edit.putString("5","obnoxious");
        edit.putString("55","desagradable");

        edit.commit();

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
        new AlertDialog.Builder(MainMenuActivity.this)
                .setTitle("Hemos activade la app")
                .setMessage("Si quieres usar la funcion de bloqueo debes quitar tu lockscreen actual")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(DevicePolicyManager.ACTION_SET_NEW_PASSWORD));
                    }
                }).show();
    }
}
