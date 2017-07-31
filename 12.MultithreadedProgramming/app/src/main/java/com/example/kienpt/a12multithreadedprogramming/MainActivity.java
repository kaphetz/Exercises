package com.example.kienpt.a12multithreadedprogramming;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFlipping(View clickedButton) {
        ExecutorService taskList = Executors.newFixedThreadPool(50);
        for(int i=0; i<5; i++) {
            taskList.execute(new Flipper());
        }
    }
}
