package com.example.se.appbox;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ExamActivity extends AppCompatActivity {

    private String answer;
    private String valueButton1;
    private String valueButton2;
    private String valueButton3;
    private String valueButton4;
    private int progress;


    private String txtValue;



    public TextView txtView;
    public TextView txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

       final TextView txtView = (TextView)findViewById(R.id.textQ1);
        final TextView txtView2 = (TextView)findViewById(R.id.textQ2);

        txtValue="¿Cual es el significado <<house>> ? ";
        txtView.setText(txtValue);


        valueButton1="Teclado";
        valueButton2="Tarea";
        valueButton3="Casa";
        valueButton4="Tabla";
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


        answer="Casa";
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


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtValue="¿Cual es el significado <<Dog>> ? ";
                answer="Perro";
                txtView.setText(txtValue);

                valueButton1="Zebra";
                valueButton2="Leon";
                valueButton3="Tigre";
                valueButton4="Perro";
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

            }
        });

    }
}
