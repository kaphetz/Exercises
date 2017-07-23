package com.example.kienpt.a08intents2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private String mBaseAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGoSum = (Button) findViewById(R.id.btn_goToSumActivity);
        Button btnGoSum2 = (Button) findViewById(R.id.btn_goToSumActivity2);
        Button btnGoSum3 = (Button) findViewById(R.id.btn_goToSumActivity3);
        btnGoSum.setOnClickListener(this);
        btnGoSum2.setOnClickListener(this);
        btnGoSum3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mBaseAddress = "sum://example.com/add";
        switch (v.getId()) {
            case R.id.btn_goToSumActivity:
                goToSumActivity();
                break;
            case R.id.btn_goToSumActivity2:
                goToSumActivity2();
                break;
            case R.id.btn_goToSumActivity3:
                goToSumActivity3();
                break;
        }
    }

    /*
     *Switch to SumActivity
     *Don't send data
     */
    public void goToSumActivity(){
        Uri uri = Uri.parse(mBaseAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    /*
     *Switch to SumActivity
     *Using URI send random number
     */
    public void goToSumActivity2(){
        Random rand = new Random();
        int firstNum = rand.nextInt(100);
        int secondNum = rand.nextInt(100);
        mBaseAddress = String.format("%s?firstNum=%s&secondNum=%s",
                mBaseAddress, firstNum, secondNum);
        Uri uri = Uri.parse(mBaseAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    /*
     *Switch to SumActivity
     *Send numbers from the two EditText fields
     */
    public void goToSumActivity3(){
        EditText etFirstNumber = (EditText) findViewById(R.id.et_firstNumber);
        EditText etSecondNumber = (EditText) findViewById(R.id.et_secondNumber);
        //check null edit text
        if (TextUtils.isEmpty(etFirstNumber.getText().toString())) {
            etFirstNumber.setError("Please input number");
            return;
        }
        if (TextUtils.isEmpty(etSecondNumber.getText().toString())) {
            etSecondNumber.setError("Please input number");
            return;
        }
        int firstNum = Integer.valueOf(etFirstNumber.getText().toString());
        int secondNum = Integer.valueOf(etSecondNumber.getText().toString());
        mBaseAddress = String.format("%s?firstNum=%s&secondNum=%s",
                mBaseAddress, firstNum, secondNum);
        Uri uri = Uri.parse(mBaseAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
