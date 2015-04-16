package com.zms.progressbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;

import com.zms.progressbar.library.ProgressBarDeterminate;
import com.zms.progressbar.library.ProgressBarIndeterminateDeterminate;


public class MainActivity extends ActionBarActivity {

    int backgroundColor = Color.parseColor("#1E88E5");

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int color = getIntent().getIntExtra("BACKGROUND", backgroundColor); // Color.BLACK
        findViewById(R.id.progressBarCircularIndetermininate).setBackgroundColor(color);
        findViewById(R.id.progressBarIndeterminate).setBackgroundColor(color);
        findViewById(R.id.progressBarIndeterminateDeterminate).setBackgroundColor(color);
        findViewById(R.id.progressDeterminate).setBackgroundColor(color);

        progreesBarDeterminate = (ProgressBarDeterminate) findViewById(R.id.progressDeterminate);
        progressTimer.start();
        progressBarIndeterminateDeterminate = (ProgressBarIndeterminateDeterminate) findViewById(R.id.progressBarIndeterminateDeterminate);
        progressTimer2.start();
    }

    ProgressBarDeterminate progreesBarDeterminate;

    Thread progressTimer = new Thread(new Runnable() {

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(new Message());
            }
        }
    });

    Handler handler = new Handler(new Handler.Callback() {
        int progress = 0;

        @Override
        public boolean handleMessage(Message msg) {
            progreesBarDeterminate.setProgress(progress++);
            return false;
        }
    });

    ProgressBarIndeterminateDeterminate progressBarIndeterminateDeterminate;

    Thread progressTimer2 = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(100);
                    handler2.sendMessage(new Message());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Handler handler2 = new Handler(new Handler.Callback() {
        int progress = 0;

        @Override
        public boolean handleMessage(Message msg) {
            progressBarIndeterminateDeterminate.setProgress(progress++);
            return false;
        }
    });

}
