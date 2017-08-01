package com.example.kienpt.a12multithreadedprograming5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFlippingCoin(View clickedButton) {
        for (int i = 0; i < 5; i++) {
            new MyAsyncTask(MainActivity.this).execute(RandomUtils.randomInt(200));
        }
    }

}
