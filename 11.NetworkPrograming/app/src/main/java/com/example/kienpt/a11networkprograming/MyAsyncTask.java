package com.example.kienpt.a11networkprograming;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class MyAsyncTask extends AsyncTask<String, Integer, Void> {
    private int mLineSum = 0;
    private String urlString = "";
    private Activity context;

    MyAsyncTask(Activity ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        EditText mEtUrl = (EditText) context.findViewById(R.id.et_url);
        urlString = mEtUrl.getText().toString();
    }

    @Override
    protected Void doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader in = new BufferedReader(inputStream);
            while (in.readLine() != null) {
                mLineSum++;
            }
        } catch (MalformedURLException e) {
            showError("Bad URL: " + e);
            e.printStackTrace(); // View this in DDMS window
        } catch (IOException e) {
            showError("Error in connection: " + e);
            e.printStackTrace(); // View this in DDMS window
        } finally {
            assert urlConnection != null;
            urlConnection.disconnect();
        }
        publishProgress();
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tvResult = (TextView) context.findViewById(R.id.tv_result);
        tvResult.setText("The number of lines is " + mLineSum);
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

    private void showError(String text) {
        TextView tvError = (TextView) context.findViewById(R.id.tv_error);
        tvError.setText(String.format("\n\n%s", text));
    }
}
