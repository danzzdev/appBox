package com.example.se.appbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.telephony.TelephonyManager;

/**
 * Created by se on 4/8/2018.
 */

public class ScreenReceiver extends WakefulBroadcastReceiver {

    public static boolean wasScreenOn = true;

    //pref
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

            prefs = context.getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
            edit=prefs.edit();


            Intent intent11 = new Intent(context,CoverLockScreenService.class);
            edit.putBoolean("BLOQ",true);
            edit.commit();

            wasScreenOn=false;
            if(((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getCallState() == 0)
            {

                intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if(Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION,0)==1)
                {
                    if(Build.VERSION.SDK_INT>=23) {
                        if (Settings.System.canWrite(context)) {
                            intent11.putExtra("B",true);
                            Settings.System.putInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0);
                        }
                    }
                    else {
                        intent11.putExtra("B",true);
                        Settings.System.putInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0);
                    }
                }
                startWakefulService(context, intent11);
                //context.startService(intent11);
            }
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            wasScreenOn=true;
        }
        else if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            Intent intent11 = new Intent(context, CoverLockScreenService.class);
            intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startWakefulService(context, intent11);
            //context.startService(intent11);
        }
    }
}
