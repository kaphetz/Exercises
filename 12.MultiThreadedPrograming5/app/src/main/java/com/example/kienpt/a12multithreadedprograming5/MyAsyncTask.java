package com.example.kienpt.a12multithreadedprograming5;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyAsyncTask extends AsyncTask<Integer, String, Void> {
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
    protected Void doInBackground(Integer... params) {
        ExecutorService taskList = Executors.newFixedThreadPool(50);
        taskList.execute(new Flipper(params[0]));
        try {
            taskList.shutdown();
            taskList.awaitTermination(HEAD_TIMEOUT,
                    TimeUnit.MINUTES);
            publishProgress(String.valueOf(Flipper.count.mMax), Flipper.mThreadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Flipper.count.mMax = 0;
        Flipper.mThreadName = "";
        return null;
    }

    // show result
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        LinearLayout llMultiThread = (LinearLayout) context.findViewById(R.id.ll_multi_thread);
        TextView displayedResult = new TextView(context);
        displayedResult.setText(String.format("Maximum number of consecutive heads of %s is: %s",
                values[1],values[0]));
        llMultiThread.addView(displayedResult);
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}

