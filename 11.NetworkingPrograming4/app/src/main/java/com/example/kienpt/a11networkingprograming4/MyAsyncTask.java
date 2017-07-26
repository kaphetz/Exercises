package com.example.kienpt.a11networkingprograming4;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class MyAsyncTask extends AsyncTask<String, String, Void> {
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
        String baseUrl = params[0];
        String loanAmount = params[1];
        String interestRateA = params[2];
        String loanPeriodA = params[3];
        String interestRateB = params[4];
        String loanPeriodB = params[5];
        LoanInputs inputsA = new LoanInputs(loanAmount, interestRateA, loanPeriodA);
        LoanInputs inputsB = new LoanInputs(loanAmount, interestRateB, loanPeriodB);
        JSONObject inputsJsonA = new JSONObject(inputsA.getInputMap());
        JSONObject inputsJsonB = new JSONObject(inputsB.getInputMap());
        try {
            String jsonStringA = HttpUtils.urlContentPost(baseUrl, "loanInputs",
                    inputsJsonA.toString());
            String jsonStringB = HttpUtils.urlContentPost(baseUrl, "loanInputs",
                    inputsJsonB.toString());
            JSONObject jsonResultA = new JSONObject(jsonStringA);
            JSONObject jsonResultB = new JSONObject(jsonStringB);
            Double totalPaymentsA = Double.valueOf(jsonResultA.getString("totalPayments"));
            Double totalPaymentsB = Double.valueOf(jsonResultB.getString("totalPayments"));
            if (totalPaymentsA > totalPaymentsB) {
                String formattedTotalPaymentsB = jsonResultB.getString("formattedTotalPayments");
                publishProgress("Plan B", formattedTotalPaymentsB );
            } else {
                String formattedTotalPaymentsA = jsonResultA.getString("formattedTotalPayments");
                publishProgress("Plan A", formattedTotalPaymentsA );
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    // show result
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        TextView tvResult = (TextView) context.findViewById(R.id.tv_result);
        tvResult.setText(String.format("%s is better with total payments is %s", values[0], values[1]));
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

    private class LoanInputs {
        private Map<String, String> mInputMap;

        private LoanInputs(String amount, String rate,
                           String months) {
            mInputMap = new HashMap<>();
            mInputMap.put("amount", amount);
            mInputMap.put("rate", rate);
            mInputMap.put("months", months);
        }

        private Map<String, String> getInputMap() {
            return (mInputMap);
        }
    }
}
