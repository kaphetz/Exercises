package com.example.kienpt.a11networkprograming2;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;

class MyAsyncTask extends AsyncTask<String, Integer, Void> {
    private Activity context;

    MyAsyncTask(Activity ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Void doInBackground(String... params) {
        String urlString = params[0];
        int counter = 0;
        try {
            String urlBody = HttpUtils.urlContent(urlString);
            String[] lines = urlBody.split("[\\n\\r]+");
            for (String line : lines) {
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(line.charAt(i))) {
                        counter++;
                    }
                }
            }
        } catch (MalformedURLException e) {
            showError("Bad URL: " + e);
            e.printStackTrace(); // View this in DDMS window
        } catch (IOException e) {
            showError("Error in connection: " + e);
            e.printStackTrace(); // View this in DDMS window
        }
        publishProgress(counter);
        return null;
    }

    // show result
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tvResult = (TextView) context.findViewById(R.id.tv_result);
        tvResult.setText(context.getString(R.string.show_message) + " " + values[0].toString());
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

