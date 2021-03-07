package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ProgressBar firstProgressBar;
    private TextView txtFirstResult;
    private Button btnStartFirstThread;

    private ProgressBar secondProgressBar;
    private TextView txtSecondResult;
    private Button btnStartSecondThread;


    private ProgressBar thirdProgressBar;
    private TextView txtThirdResult;
    private Button btnStartThirdThread;

    private Button btnSayToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        firstProgressBar = findViewById(R.id.firstProgressBar);
        txtFirstResult = findViewById(R.id.txtFirstResult);
        btnStartFirstThread = findViewById(R.id.btnStartFirstThread);

        secondProgressBar = findViewById(R.id.secondProgressBar);
        txtSecondResult = findViewById(R.id.txtSecondResult);
        btnStartSecondThread = findViewById(R.id.btnStartSecondThread);

        thirdProgressBar = findViewById(R.id.thirdProgressBar);
        txtThirdResult = findViewById(R.id.txtThirdResult);
        btnStartThirdThread = findViewById(R.id.btnStartThirdThread);

        btnSayToast = findViewById(R.id.btnSayToast);

        btnStartFirstThread.setOnClickListener(this);
        btnStartSecondThread.setOnClickListener(this);
        btnStartThirdThread.setOnClickListener(this);


        btnSayToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnStartFirstThread:
                startFirstThread();
                break;
            case R.id.btnStartSecondThread:
                startSecondThread();
                break;
            case R.id.btnStartThirdThread:
                startThirdThread();
                break;
            case R.id.btnSayToast:
                Toast.makeText(this, "За здоровье", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startThirdThread() {

        Runnable myBackgroundJob = new Runnable() {
            @Override
            public void run() {

                txtThirdResult.post(new Runnable() {
                    @Override
                    public void run() {
                        txtThirdResult.setText("Третий фоновый поток начал работу");

                    }
                });


                for (int i = 0; i < 11; i++)
                {
                    SystemClock.sleep(3000);

                    final int currentProgress = i;

                    thirdProgressBar.post(new Runnable() {
                        @Override
                        public void run() {

                            thirdProgressBar.setProgress(currentProgress);
                        }
                    });
                }

                txtThirdResult.post(new Runnable() {
                    @Override
                    public void run() {
                        txtThirdResult.setText("Третий фоновый поток закончил работу");

                    }
                });


            }
        };

        Thread myThread = new Thread(myBackgroundJob);
        myThread.start();

    }

    private void startSecondThread() {

        Runnable myBackgroundJob = new Runnable() {
            @Override
            public void run() {

                txtSecondResult.post(new Runnable() {
                    @Override
                    public void run() {
                        txtSecondResult.setText("Второй фоновый поток начал работу");

                    }
                });


                for (int i = 0; i < 11; i++)
                {
                    SystemClock.sleep(2000);

                    final int currentProgress = i;

                    secondProgressBar.post(new Runnable() {
                        @Override
                        public void run() {

                            secondProgressBar.setProgress(currentProgress);
                        }
                    });
                }

                txtSecondResult.post(new Runnable() {
                    @Override
                    public void run() {
                        txtSecondResult.setText("Второй фоновый поток закончил работу");

                    }
                });


            }
        };

        Thread myThread = new Thread(myBackgroundJob);
        myThread.start();

    }

    private void startFirstThread() {

        Runnable myBackgroundJob = new Runnable() {
            @Override
            public void run() {

                txtFirstResult.post(new Runnable() {
                    @Override
                    public void run() {
                        txtFirstResult.setText("Первый фоновый поток начал работу");

                    }
                });


                for (int i = 0; i < 11; i++)
                {
                    SystemClock.sleep(1000);

                    final int currentProgress = i;

                    firstProgressBar.post(new Runnable() {
                        @Override
                        public void run() {

                            firstProgressBar.setProgress(currentProgress);
                        }
                    });
                }

                txtFirstResult.post(new Runnable() {
                    @Override
                    public void run() {
                        txtFirstResult.setText("Первый фоновый поток закончил работу");

                    }
                });


            }
        };

        Thread myThread = new Thread(myBackgroundJob);
        myThread.start();

    }
}