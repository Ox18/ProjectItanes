package com.example.projectitanes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        int progress = progressBar.getProgress();
        setProgressValue(progress);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 5000
        );
    }

    private void setProgressValue(final int progress){
        progressBar.setProgress(progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(35);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(progress < 100){
                    setProgressValue(progress + 1);
                }
            }
        });
        thread.start();
    }

}
