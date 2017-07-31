package com.example.kienpt.a12multithreadprograming3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFlipping(View clickedButton) {
        ExecutorService taskList = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 5; i++) {
            taskList.execute(new Flipper());
        }
    }

    //use an inner class for the Flipper
    private class Flipper implements Runnable {
        public void run() {
            int heads = 0;
            for (int i = 0; i < 1000; i++) {
                String threadName = Thread.currentThread().getName();
                if (RandomUtils.randomInt(2) == 1) {
                    heads++;
                } else {
                    if (heads >= 3) {
                        System.out.printf("%s: At the %s times - Get %s consecutive heads%n",
                                threadName, i, heads);
                    }
                    heads = 0;
                }
                ThreadUtils.pause(Math.random());
            }
        }
    }
}

class ThreadUtils {
    static void pause(double seconds) {
        try {
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

class RandomUtils {
    private static Random r = new Random();

    static int randomInt(int range) {
        return (r.nextInt(range));
    }
}