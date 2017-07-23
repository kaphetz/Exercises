package com.example.kienpt.a08intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private int mFirstNumber = 5;
    private int mSecondNumber = 3;
    private int mSum = mFirstNumber + mSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnGoTo1 = (Button) findViewById(R.id.btnGoTo1);
        TextView tvSum = (TextView) findViewById(R.id.tv_sum);
        getDataFromBundle();
        getDataFromURI();
        tvSum.setText("The sum of " + String.valueOf(mFirstNumber) + " and " +
                String.valueOf(mSecondNumber) + " is " + String.valueOf(mSum));
        btnGoTo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(activityIntent);
            }
        });
    }

    // get data from main activity using bundle
    private void getDataFromBundle() {
        Intent intent = getIntent();
        Bundle info = intent.getExtras();
        if (info != null) {
            mFirstNumber = info.getInt("firstNum");
            mSecondNumber = info.getInt("secondNum");
            mSum = mFirstNumber + mSecondNumber;
        }
    }

    //get data from other activity by using URI
    private void getDataFromURI() {
        Uri uri = getIntent().getData();
        if (uri != null) {
            if (uri.getQueryParameter("firstNum") != null) {
                mFirstNumber = Integer.valueOf(uri.getQueryParameter("firstNum"));
            }
            if (uri.getQueryParameter("secondNum") != null) {
                mSecondNumber = Integer.valueOf(uri.getQueryParameter("secondNum"));
            }
            mSum = mFirstNumber + mSecondNumber;
        }
    }
}
