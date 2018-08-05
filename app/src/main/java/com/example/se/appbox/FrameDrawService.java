package com.example.se.appbox;

import android.animation.Animator;
import android.app.AlertDialog;
import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
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


    private GestureDetector detector;

    //labels
    private TextView label1,label2;

    //pref
    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        prefs = getSharedPreferences("CACHESD", Context.MODE_PRIVATE);
        edit=prefs.edit();

        cargarCover();

        setAnimation();

        handler=new Handler();

        detector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                warnigndialog();
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, final float velocityX, final float velocityY) {

                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > 60 && Math.abs(velocityX) > 1) {
                            if (diffX > 0) {
                                warnigndialog();
                            } else {
                                warnigndialog2();
                            }
                        }
                    } else {
                        if (Math.abs(diffY) > 60 && Math.abs(velocityY) > 1) {
                            if (diffY > 0) {
                                //hacia abajo
                            } else {
                                //hacia arriba
                            }
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return true;
            }
        });



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
        String frase1=prefs.getString("A"+c,"Frase por defecto 1");
        String frase2=prefs.getString("B"+c,"Frase por defecto 2");
        int nuevacategoria=Integer.parseInt(prefs.getString("C","999"))+1;

        edit.putString(c+"A",frase1);
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
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN|WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD,
                PixelFormat.TRANSLUCENT
        );
        handleParams.gravity = Gravity.TOP;
        this.winManager.addView(this.wrapperView, handleParams);
        View.inflate(getApplicationContext(), R.layout.layout_frame, this.wrapperView);
        lay=(LinearLayout)wrapperView.findViewById(R.id.framelayout);
        lay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
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
        animador.setDuration(100);
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

    public void warnigndialog()
    {

        Intent i=new Intent(FrameDrawService.this,BoxInfActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startEndingAnimation();
        startActivity(i);

    }

    public void warnigndialog2()
    {

    }
}
