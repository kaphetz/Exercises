package com.example.kienpt.a12multithreadprograming4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements Runnable {

    private static final int HEAD_TIMEOUT = 10;
    private final Count count = new Count();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFlipping(View clickedButton) {
        count.max = 0;
        ExecutorService taskList = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 5; i++) {
            taskList.execute(this);
        }
        try {
            taskList.shutdown();
            taskList.awaitTermination(HEAD_TIMEOUT,
                    TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinearLayout llMultiThread = (LinearLayout) findViewById(R.id.ll_multi_thread);
        TextView displayedResult = new TextView(this);
        displayedResult.setText(String.format("Max consecutive heads: %s",
                String.valueOf(count.max)));
        llMultiThread.addView(displayedResult);
    }

    public void run() {
        int heads = 0;
        for (int i = 0; i < 50; i++) {
            String threadName = Thread.currentThread().getName();
           // synchronized (count) {
                if (RandomUtils.randomInt(2) == 1) {
                    heads++;
                } else {
                    if (heads >= 3) {
                        if (heads >= count.max) {
                            count.change(heads);
                        }
                        System.out.printf("%s: At the %s times - Get %s consecutive heads%n",
                                threadName, i, heads);
                    }
                    heads = 0;
                }
           // }
            ThreadUtils.pause(Math.random());
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

class Count {
    public int max = 0;

    public void change(int heads) {
        max = heads;
    }

}