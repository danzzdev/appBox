package com.example.se.appbox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {

    private String answer;
    private String valueButton1;
    private String valueButton2;
    private String valueButton3;
    private String valueButton4;
    private int progress;
    private String txtValue;
    private TextView tq2qxtView;
    private TextView txtView2;

    private String[]  questions;
    private String[]  answers;
   private int contadorQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

       final TextView txtView = (TextView)findViewById(R.id.textQ1);
        final TextView txtView2 = (TextView)findViewById(R.id.textQ2);

        contadorQ=0;


        questions= new String[5] ;
        answers= new String[20] ;

        questions[0]="Im going to walk the dog";
        questions[1]="Back away";
        questions[2]="I'm starting to break away from the traditions I was raised in";
        questions[3]="The train drew into the station";
        questions[4]="obnoxious";

        answers[0]="Voy a pasear al perro";
        answers[1]="Yo saqué a pasear al perro";
        answers[2]="Yo quiero pasear al perro";
        answers[3]="Yo salí a pasear al perro";

        answers[4]="Intentarlo de nuevo";
        answers[5]="Volver a intentarlo";
        answers[6]="Retroceder";
        answers[7]="Caer";

        answers[8]="Estoy comenzando a olvidar las tradiciones con las que me criaron";
        answers[9]="Estoy comenzando a alejarme de las tradiciones con las que me criaron";
        answers[10]="Estoy comenzando a odiar las tradiciones con las que me criaron";
        answers[11]="Estoy comenzando a recordar las tradiciones con las que me criaron";


        answers[12]="El tren llegó a la estación";
        answers[13]="El tren salió de la estación";
        answers[14]="El tren se estrelló en la estación";
        answers[15]="El tren se dañó a la estación";


        answers[16]="Bueno";
        answers[17]="Gracioso";
        answers[18]="Limpio";
        answers[19]="Desagradable";

        txtValue=questions[contadorQ];
        txtView.setText(txtValue);
        valueButton1=answers[0];
        valueButton2=answers[1];
        valueButton3=answers[2];
        valueButton4=answers[3];
        answer=answers[0];

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(valueButton1);
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(valueButton2);
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setText(valueButton3);
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setText(valueButton4);

        final Button buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setEnabled(false);


        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress=0;
        progressBar.setProgress(progress);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(valueButton1)){
                    button1.setBackgroundColor(Color.GREEN);
                    txtView2.setText("Correct Answer");
                    txtView2.setTextColor(Color.GREEN);
                }
                else{
                    txtView2.setText("Wrong Answer");
                    txtView2.setTextColor(Color.RED);
                    button1.setBackgroundColor(Color.RED);
                    if (answer.equals(valueButton2)){
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton3)){
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton4)){
                        button4.setBackgroundColor(Color.GREEN);
                    }

                }
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                buttonNext.setEnabled(true);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(valueButton2)){
                    button2.setBackgroundColor(Color.GREEN);
                    txtView2.setText("Correct Answer");
                    txtView2.setTextColor(Color.GREEN);

                }
                else{
                    txtView2.setText("Wrong Answer");
                    txtView2.setTextColor(Color.RED);
                    button2.setBackgroundColor(Color.RED);
                    if (answer.equals(valueButton1)){
                        button1.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton3)){
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton4)){
                        button4.setBackgroundColor(Color.GREEN);
                    }
                }
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                buttonNext.setEnabled(true);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(valueButton3)){
                    button3.setBackgroundColor(Color.GREEN);
                    txtView2.setText("Correct Answer");
                    txtView2.setTextColor(Color.GREEN);

                }
                else{
                    txtView2.setText("Wrong Answer");
                    txtView2.setTextColor(Color.RED);
                    button3.setBackgroundColor(Color.RED);
                    if (answer.equals(valueButton2)){
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton1)){
                        button1.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton4)){
                        button4.setBackgroundColor(Color.GREEN);
                    }
                }
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                buttonNext.setEnabled(true);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals(valueButton4)){
                    button4.setBackgroundColor(Color.GREEN);
                    txtView2.setText("Correct Answer");
                    txtView2.setTextColor(Color.GREEN);

                }
                else{
                    txtView2.setText("Wrong Answer");
                    txtView2.setTextColor(Color.RED);
                    button4.setBackgroundColor(Color.RED);
                    if (answer.equals(valueButton2)){
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton3)){
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    if (answer.equals(valueButton1)){
                        button1.setBackgroundColor(Color.GREEN);
                    }
                }
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                buttonNext.setEnabled(true);
            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contadorQ<4){
                    contadorQ++;
                }
                txtValue=questions[contadorQ];
                if(contadorQ==1){
                    answer=answers[6];
                    valueButton1=answers[4];
                    valueButton2=answers[5];
                    valueButton3=answers[6];
                    valueButton4=answers[7];
                }
                if(contadorQ==2){
                    answer=answers[9];
                    valueButton1=answers[8];
                    valueButton2=answers[9];
                    valueButton3=answers[10];
                    valueButton4=answers[11];
                }
                if(contadorQ==3){
                    answer=answers[12];
                    valueButton1=answers[12];
                    valueButton2=answers[13];
                    valueButton3=answers[14];
                    valueButton4=answers[15];
                }
                if(contadorQ==4){
                    answer=answers[19];
                    valueButton1=answers[16];
                    valueButton2=answers[17];
                    valueButton3=answers[18];
                    valueButton4=answers[19];
                }

                txtView.setText(txtValue);
                button1.setText(valueButton1);
                button2.setText(valueButton2);
                button3.setText(valueButton3);
                button4.setText(valueButton4);
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);

                button1.setBackgroundColor(Color.WHITE);
                button2.setBackgroundColor(Color.WHITE);
                button3.setBackgroundColor(Color.WHITE);
                button4.setBackgroundColor(Color.WHITE);


                buttonNext.setEnabled(false);
                txtView2.setText("");
                progress+=20;
                progressBar.setProgress(progress);

                if (progress==100){
                    Intent myIntent = new Intent(ExamActivity.this, WelcomeActivity.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(myIntent);

                }


            }
        });

    }
}
