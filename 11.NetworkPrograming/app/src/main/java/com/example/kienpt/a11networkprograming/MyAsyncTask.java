package com.example.kienpt.a11networkprograming;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    private TextView mTvError;
    private TextView mTvResult;
    private int mLineSum = 0;
    Activity contextCha;

    public MyAsyncTask(Activity ctx) {
        contextCha = ctx;
    }

    @Override
    protected Void doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://www.java2s.com/Code/Android/Network/ReadfromaURL.htm");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader in = new BufferedReader(inputStream);
            while (in.readLine() != null) {
                mLineSum++;
            }
        } catch (MalformedURLException e) {
            showError("Bad URL: ");
            e.printStackTrace(); // View this in DDMS window
        } catch (IOException e) {
            showError("Error in connection: " + e);
            e.printStackTrace(); // View this in DDMS window
        } finally {
            assert urlConnection != null;
            urlConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mTvResult = (TextView) contextCha.findViewById(R.id.tv_result);
        mTvResult.setText(mLineSum);
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        Toast.makeText(contextCha, "Update xong roi do!" + mLineSum,
                Toast.LENGTH_LONG).show();
    }

    private void showError(String text) {
        mTvError = (TextView) contextCha.findViewById(R.id.tv_error);
        mTvError.setText(String.format("\n\n%s", text));
    }
}
