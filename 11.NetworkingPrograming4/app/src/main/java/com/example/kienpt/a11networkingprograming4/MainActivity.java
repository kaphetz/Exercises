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

                EditText etLoanAmount = (EditText) findViewById(R.id.et_loanAmount);
                EditText etInterestRatesA = (EditText) findViewById(R.id.et_interestRatesA);
                EditText etPeriodsInMonthsA = (EditText) findViewById(R.id.et_periodsInMonthsA);
                EditText etInterestRatesB = (EditText) findViewById(R.id.et_interestRatesB);
                EditText etPeriodsInMonthsB = (EditText) findViewById(R.id.et_periodsInMonthsB);
                String loanAmount = etLoanAmount.getText().toString();
                String interestRateA = etInterestRatesA.getText().toString();
                String loanPeriodA = etPeriodsInMonthsA.getText().toString();
                String interestRateB = etInterestRatesB.getText().toString();
                String loanPeriodB = etPeriodsInMonthsB.getText().toString();
                //check empty
                if (TextUtils.isEmpty(loanAmount)) {
                    etLoanAmount.setError("Please enter loan mount");
                    return;
                }
                if (TextUtils.isEmpty(interestRateA)) {
                    etInterestRatesA.setError("Please enter interest rate");
                    return;
                }
                if (TextUtils.isEmpty(loanPeriodA)) {
                    etPeriodsInMonthsA.setError("Please enter period");
                    return;
                }
                if (TextUtils.isEmpty(interestRateB)) {
                    etInterestRatesB.setError("Please enter interest rate");
                    return;
                }
                if (TextUtils.isEmpty(loanPeriodB)) {
                    etPeriodsInMonthsB.setError("Please enter period");
                    return;
                }
                new MyAsyncTask(MainActivity.this).execute(baseUrl, loanAmount, interestRateA,
                        loanPeriodA, interestRateB, loanPeriodB);
            }
        });
    }
}
