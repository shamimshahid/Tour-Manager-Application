package com.nadxlib.dort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pro;
    private int prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        pro = (ProgressBar) findViewById(R.id.progressbar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startapp();
            }
        });
        thread.start();

    }
    public void doWork()
    {  for(prog=20;prog<=100;prog=prog+20){
        try {
            Thread.sleep(800);
            pro.setProgress(prog);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
    public void startapp()
    {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
        finish();
    }
}