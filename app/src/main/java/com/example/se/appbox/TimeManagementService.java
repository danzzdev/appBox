package com.example.se.appbox;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;

import java.util.LinkedList;

public class TimeManagementService extends Service {

    private int cont;
    private Handler handler;
    private int category;
    private int contCategory;
    private LinkedList listaA,listaB,listaC;

    //pref
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;



    public TimeManagementService() {
        cont=1;
        handler=new Handler();
        category=1;
        contCategory=1;
        listaA=new LinkedList<String>();
        listaB=new LinkedList<String>();
        listaC=new LinkedList<String>();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private BroadcastReceiver mReceiver;

    @Override
    public void onCreate() {

        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);

        IntentFilter filter2 = new IntentFilter(Intent.ACTION_PICK_ACTIVITY);
        filter2.setPriority(Integer.MAX_VALUE);

        mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, filter);


        super.onCreate();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        final Runnable publicarframe=new Runnable() {
            @Override
            public void run() {
                Intent intent11 = new Intent(getApplicationContext(), FrameDrawService.class);
                intent11.putExtra("C",category);
                if(category==3)
                category=1;
                else
                category++;

                intent11.putExtra("Ccont",contCategory);
                intent11.putExtra("N",cont);
                intent11.putExtra("N",cont);
                cont++;
                intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                handler.postDelayed(this,10000);
                if(!prefs.getBoolean("BLOQ",false))
                startService(intent11);
            }
        };


        handler.postDelayed(publicarframe,1000);


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

}
