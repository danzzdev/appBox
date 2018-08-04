package com.example.se.appbox;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;

public class TimeManagementService extends Service {

    private int cont;
    private Handler handler;



    public TimeManagementService() {
        cont=1;
        handler=new Handler();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private BroadcastReceiver mReceiver;

    @Override
    public void onCreate() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);

        IntentFilter filter2 = new IntentFilter(Intent.ACTION_PICK_ACTIVITY);
        filter2.setPriority(Integer.MAX_VALUE);

        mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, filter);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        final Runnable publicarframe=new Runnable() {
            @Override
            public void run() {
                Intent intent11 = new Intent(getApplicationContext(), FrameDrawService.class);
                intent11.putExtra("N",cont);
                cont++;
                intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                handler.postDelayed(this,20000);
                startService(intent11);
            }
        };


        handler.postDelayed(publicarframe,20000);


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

}
