package com.example.kienpt.a12multithreadprograming4;

import java.util.Random;

class Flipper implements Runnable {
    public static Count count = new Count();

    public void run() {
        int heads = 0;
        for (int i = 0; i < 20; i++) {
            String threadName = Thread.currentThread().getName();
            if (RandomUtils.randomInt(2) == 1) {
                heads++;
            } else {
                synchronized (count) {  // tạm khóa đối tượng count lại và thực hiện đoạn chương trình
                    if (heads > count.mMax) {
                        count.change(heads);
                    }
                }
                System.out.printf("%s: At the %s times - Get %s consecutive heads%n",
                        threadName, i, heads);
                System.out.printf("Max la: %s\n",
                        count.mMax);
                heads = 0;
            }
            ThreadUtils.pause(Math.random());
        }
    }

    static class Count {
        public int mMax;

        public void change(int newMax) {
            mMax = newMax;
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


