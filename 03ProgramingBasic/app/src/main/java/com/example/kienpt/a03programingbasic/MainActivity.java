package com.example.kienpt.a03programingbasic;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPushMe;
    private Button mBtnClickMe;

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
                changeForegroundColor(mBtnPushMe);
                mBtnPushMe.setText("I was clicked " + String.valueOf(++countPushMe) + " times");
                Toast.makeText(MainActivity.this, confirmText, Toast.LENGTH_SHORT).show();
            }
        });

        mBtnClickMe.setOnClickListener(new View.OnClickListener() {
            int countClickMe = 0;

            @Override
            public void onClick(View view) {
                String confirmText = "Click Me is clicked";
                changeForegroundColor(mBtnClickMe);
                mBtnClickMe.setText("I was clicked " + String.valueOf(++countClickMe) + " times");
                Toast.makeText(MainActivity.this, confirmText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectView() {
        mBtnPushMe = (Button) findViewById(R.id.btn_pushMe);
        mBtnClickMe = (Button) findViewById(R.id.btn_clickMe);
    }

    /*-
     * change foreground color of button
     */
    private void changeForegroundColor(Button btn) {
        int color = randInt(0, 2);
        switch (color) {
            case 0:
                btn.setBackgroundColor(Color.RED);
                break;
            case 1:
                btn.setBackgroundColor(Color.YELLOW);
                break;
            default:
                btn.setBackgroundColor(Color.BLUE);
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
