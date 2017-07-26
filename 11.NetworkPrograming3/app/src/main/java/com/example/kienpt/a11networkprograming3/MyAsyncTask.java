package com.example.kienpt.a11networkprograming3;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

class MyAsyncTask extends AsyncTask<String, JSONObject, Void> {
    private Activity context;
    private TextView mTvLoanPeriodInMonths,
            mTvLoanAmount,
            mTvFormattedAnnualInterestRateInPercent,
            mTvTotalPayments,
            mTvCurrencySymbol,
            mTvAnnualInterestRateInPercent,
            mTvMonthlyPayment,
            mTvFormattedLoanAmount,
            mTvFormattedMonthlyPayment,
            mTvFormattedLoanPeriodInMonths,
            mTvFormattedTotalPayments;

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
        mTvLoanPeriodInMonths = (TextView) context.findViewById(R.id.tv_loanPeriodInMonths);
        mTvLoanAmount = (TextView) context.findViewById(R.id.tv_loanAmount);
        mTvFormattedAnnualInterestRateInPercent = (TextView) context.findViewById(R.id.tv_formattedAnnualInterestRateInPercent);
        mTvTotalPayments = (TextView) context.findViewById(R.id.tv_totalPayments);
        mTvCurrencySymbol = (TextView) context.findViewById(R.id.tv_currencySymbol);
        mTvAnnualInterestRateInPercent = (TextView) context.findViewById(R.id.tv_annualInterestRateInPercent);
        mTvMonthlyPayment = (TextView) context.findViewById(R.id.tv_monthlyPayment);
        mTvFormattedLoanAmount = (TextView) context.findViewById(R.id.tv_formattedLoanAmount);
        mTvFormattedMonthlyPayment = (TextView) context.findViewById(R.id.tv_formattedMonthlyPayment);
        mTvFormattedLoanPeriodInMonths = (TextView) context.findViewById(R.id.tv_formattedLoanPeriodInMonths);
        mTvFormattedTotalPayments = (TextView) context.findViewById(R.id.tv_formattedTotalPayments);
        try {
            String jsonString = HttpUtils.urlContentPost(baseUrl);
            JSONObject jsonResult = new JSONObject(jsonString);
            publishProgress(jsonResult);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    // show result
    @Override
    protected void onProgressUpdate(JSONObject... values) {
        super.onProgressUpdate(values);
        JSONObject result = values[0];
        try {
            mTvLoanPeriodInMonths.setText(context.getString(R.string.loan_period_in_months) + " " +
                    result.getString("loanPeriodInMonths"));
            mTvLoanAmount.setText(context.getString(R.string.loan_amount) + " " +
                    result.getString("loanAmount"));
            mTvFormattedAnnualInterestRateInPercent.setText(
                    context.getString(R.string.formatted_annual_interest_rate_in_percent) + " " +
                            result.getString("formattedAnnualInterestRateInPercent"));
            mTvTotalPayments.setText(context.getString(R.string.total_payments) + " " +
                    result.getString("totalPayments"));
            mTvCurrencySymbol.setText(context.getString(R.string.currency_symbol) + " " +
                    result.getString("currencySymbol"));
            mTvAnnualInterestRateInPercent.setText(
                    context.getString(R.string.annual_interest_rate_in_percent) + " " +
                            result.getString("annualInterestRateInPercent"));
            mTvMonthlyPayment.setText(context.getString(R.string.monthly_payment) + " " +
                    result.getString("monthlyPayment"));
            mTvFormattedLoanAmount.setText(context.getString(R.string.formatted_loan_amount) + " " +
                    result.getString("formattedLoanAmount"));
            mTvFormattedMonthlyPayment.setText(
                    context.getString(R.string.formatted_monthly_payment) + " " +
                            result.getString("formattedMonthlyPayment"));
            mTvFormattedLoanPeriodInMonths.setText(
                    context.getString(R.string.formatted_loan_period_in_months) + " " +
                            result.getString("formattedLoanPeriodInMonths"));
            mTvFormattedTotalPayments.setText(
                    context.getString(R.string.formatted_total_payments) + " " +
                            result.getString("formattedTotalPayments"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

}
