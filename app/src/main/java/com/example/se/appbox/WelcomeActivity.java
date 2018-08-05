package com.example.se.appbox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        final Button button1 = (Button) findViewById(R.id.buttonEasy);
        button1.setEnabled(false);
        final Button button2 = (Button) findViewById(R.id.buttonMedium);
        button2.setEnabled(true);
        final Button button3 = (Button) findViewById(R.id.buttonHard);
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
}
