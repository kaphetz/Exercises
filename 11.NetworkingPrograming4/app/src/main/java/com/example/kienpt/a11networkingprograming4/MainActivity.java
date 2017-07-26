package com.example.kienpt.a11networkingprograming4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalculate = (Button) findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseUrl = "http://apps.coreservlets.com/NetworkingSupport/loan-calculator";

                EditText mEtLoanAmount = (EditText) findViewById(R.id.et_loanAmount);
                EditText mEtInterestRatesA = (EditText) findViewById(R.id.et_interestRatesA);
                EditText mEtPeriodsInMonthsA = (EditText) findViewById(R.id.et_periodsInMonthsA);
                EditText mEtInterestRatesB = (EditText) findViewById(R.id.et_interestRatesB);
                EditText mEtPeriodsInMonthsB = (EditText) findViewById(R.id.et_periodsInMonthsB);
                String loanAmount = mEtLoanAmount.getText().toString();
                String interestRateA = mEtInterestRatesA.getText().toString();
                String loanPeriodA = mEtPeriodsInMonthsA.getText().toString();
                String interestRateB = mEtInterestRatesB.getText().toString();
                String loanPeriodB = mEtPeriodsInMonthsB.getText().toString();
                //check empty
                if (TextUtils.isEmpty(loanAmount)) {
                    mEtLoanAmount.setError("Please enter loan mount");
                    return;
                }
                if (TextUtils.isEmpty(interestRateA)) {
                    mEtInterestRatesA.setError("Please enter interest rate");
                    return;
                }
                if (TextUtils.isEmpty(loanPeriodA)) {
                    mEtPeriodsInMonthsA.setError("Please enter period");
                    return;
                }
                if (TextUtils.isEmpty(interestRateB)) {
                    mEtInterestRatesB.setError("Please enter interest rate");
                    return;
                }
                if (TextUtils.isEmpty(loanPeriodB)) {
                    mEtPeriodsInMonthsB.setError("Please enter period");
                    return;
                }
                MyAsyncTask myTask;
                myTask = new MyAsyncTask(MainActivity.this);
                myTask.execute(baseUrl, loanAmount, interestRateA, loanPeriodA,
                        interestRateB, loanPeriodB);
            }
        });
    }
}
