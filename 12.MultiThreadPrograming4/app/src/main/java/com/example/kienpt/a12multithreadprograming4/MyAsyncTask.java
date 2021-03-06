package com.example.kienpt.a12multithreadprograming4;

import android.app.Activity;
import android.os.AsyncTask;
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
            publishProgress(Flipper.count.mMax);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Flipper.count.mMax = 0;
        return null;
    }

    // show result
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tvShowMax = (TextView)context.findViewById(R.id.tv_showMax);
        tvShowMax.setText(String.format("Max consecutive heads: %s",
                String.valueOf(values[0])));
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}

