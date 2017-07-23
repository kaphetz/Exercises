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

    public void goToSumActivity(){
        mBaseAddress = "sum://example.com/add";
        Uri uri = Uri.parse(mBaseAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goToSumActivity2(){
        mBaseAddress = "sum://example.com/add";
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        mBaseAddress = String.format("%s?a=%s&b=%s", mBaseAddress, a, b);
        Uri uri = Uri.parse(mBaseAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goToSumActivity3(){
        mBaseAddress = "sum://example.com/add";
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
        int a = Integer.valueOf(etFirstNumber.getText().toString());
        int b = Integer.valueOf(etSecondNumber.getText().toString());
        mBaseAddress = String.format("%s?a=%s&b=%s", mBaseAddress, a, b);
        Uri uri = Uri.parse(mBaseAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
