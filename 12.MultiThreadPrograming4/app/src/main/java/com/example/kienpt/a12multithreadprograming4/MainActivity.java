package com.example.kienpt.a12multithreadprograming4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFlipping(View clickedButton) {
        new MyAsyncTask(MainActivity.this).execute();
    }

    /*public void run() {
        int heads = 0;
        for (int i = 0; i < 50; i++) {
            String threadName = Thread.currentThread().getName();
            synchronized (count) {
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
           }
            ThreadUtils.pause(Math.random());
        }
    }*/
}
/*

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
*/

