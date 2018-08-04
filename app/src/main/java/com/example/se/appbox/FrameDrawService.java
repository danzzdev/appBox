package com.example.se.appbox;

import android.animation.Animator;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FrameDrawService extends Service {

    //Managment Display
    private WindowManager winManager;
    private RelativeLayout wrapperView;

    //Animacion
    ViewPropertyAnimator animador;
    private int ancho;
    private LinearLayout lay;

    //Intent Srvice
    private Intent intentService;

    //Handler
    private Handler handler;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //labels
    private TextView label1,label2;

    //pref
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        cargarCover();

        setAnimation();

        handler=new Handler();



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Runnable fadedownFrame=new Runnable() {
            @Override
            public void run() {
                startEndingAnimation();
            }
        };

        String c=intent.getIntExtra("N",99999)+"";
        String frase1=prefs.getString(c,"Frase por defecto 1");
        String frase2=prefs.getString(c+c,"Frase por defecto 2");
        label1.setText(frase1);
        label2.setText(frase2);

        handler.postDelayed(fadedownFrame,5000);

        return START_NOT_STICKY;
    }

    public void cargarCover()
    {
        this.winManager = ((WindowManager)getApplicationContext().getSystemService(WINDOW_SERVICE));
        this.wrapperView = new RelativeLayout(getBaseContext());
        WindowManager.LayoutParams handleParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                // This allows the view to be displayed over the status bar
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                // this is to keep button presses going to the background window
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        // this is to enable the notification to recieve touch events
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                        // Draws over status bar
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN|WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD,
                PixelFormat.TRANSLUCENT
        );
        handleParams.gravity = Gravity.TOP;
        this.winManager.addView(this.wrapperView, handleParams);
        View.inflate(getApplicationContext(), R.layout.layout_frame, this.wrapperView);
        lay=(LinearLayout)wrapperView.findViewById(R.id.framelayout);
        Point punto=new Point();
        winManager.getDefaultDisplay().getSize(punto);
        ancho=punto.x;
        animador=lay.animate();

        //labels
        label1=lay.findViewById(R.id.label1);
        label2=lay.findViewById(R.id.label2);



    }
    public  void startEndingAnimation()
    {
        animador.setDuration(500);
        animador.translationX(ancho);
        animador.start();
    }
    public void setAnimation()
    {
        //Animacion
        animador=lay.animate();
        animador.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                wrapperView.setVisibility(View.GONE);
                //finish();
                //manager.unregisterListener(liste);
                stopSelf();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
