package com.example.se.appbox;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CoverLockScreenService extends Service {
    public CoverLockScreenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
