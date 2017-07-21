package com.example.kienpt.a03programingbasic2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPushMe;
    private Button mBtnClickMe;
    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        mBtnPushMe.setOnClickListener(new View.OnClickListener() {
            int countPushMe = 0;
            @Override
            public void onClick(View view) {
                String confirmText = "Push Me is clicked";
                changeTextViewColor(mTvTest);
                mBtnPushMe.setText("I was clicked " + String.valueOf(++countPushMe) + " times");
                Toast.makeText(MainActivity.this, confirmText, Toast.LENGTH_SHORT).show();
            }
        });

        mBtnClickMe.setOnClickListener(new View.OnClickListener() {
            int countClickMe = 0;
            @Override
            public void onClick(View view) {
                String confirmText = "Click Me is clicked";
                changeTextViewColor(mTvTest);
                mBtnClickMe.setText("I was clicked " + String.valueOf(++countClickMe) + " times");
                Toast.makeText(MainActivity.this, confirmText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectView() {
        mBtnPushMe = (Button) findViewById(R.id.btn_pushMe);
        mBtnClickMe = (Button) findViewById(R.id.btn_clickMe);
        mTvTest = (TextView) findViewById(R.id.tv_test);
    }

    /*-
     * change color of textview
     */
    private void changeTextViewColor(TextView tv) {
        int i = randInt(0, 2);
        switch (i) {
            case 0:
                tv.setBackgroundColor(Color.RED);
                break;
            case 1:
                tv.setBackgroundColor(Color.YELLOW);
                break;
            default:
                tv.setBackgroundColor(Color.BLUE);
        }
    }

    /*-
     * random int
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
