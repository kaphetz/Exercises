package com.example.kienpt.a12multithreadprograming4;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyAsyncTask extends AsyncTask<Objects, Integer, Void> {
    private Activity context;

    private static final int HEAD_TIMEOUT = 10;

    MyAsyncTask(Activity ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Void doInBackground(Objects... params) {
        ExecutorService taskList = Executors.newFixedThreadPool(50);
        for(int i=0; i<5; i++) {
            taskList.execute(new Flipper());
        }
        try {
            taskList.shutdown();
            taskList.awaitTermination(HEAD_TIMEOUT,
                    TimeUnit.MINUTES);
            publishProgress(Flipper.count.max);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Flipper.count.max = 0;
        return null;
    }

    // show result
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        LinearLayout llMultiThread = (LinearLayout) context.findViewById(R.id.ll_multi_thread);
        TextView displayedResult = new TextView(context);
        displayedResult.setText(String.format("Max consecutive heads: %s",
                String.valueOf(values[0])));
        llMultiThread.addView(displayedResult);
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}

