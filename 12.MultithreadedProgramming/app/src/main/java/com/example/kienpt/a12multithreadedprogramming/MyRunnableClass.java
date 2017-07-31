package com.example.kienpt.a12multithreadedprogramming;

import java.util.Random;

class Flipper implements Runnable {
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