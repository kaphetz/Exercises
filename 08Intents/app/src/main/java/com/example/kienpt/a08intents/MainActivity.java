package com.example.kienpt.a08intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGoTo2 = (Button) findViewById(R.id.btn_goTo2);
        Button btnGoTo3 = (Button) findViewById(R.id.btn_goTo3);

        btnGoTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle newActivityInfo = new Bundle();
                Random rand = new Random();
                int firstNum = rand.nextInt(100);
                int secondNum = rand.nextInt(100);
                newActivityInfo.putInt("firstNum", firstNum);
                newActivityInfo.putInt("secondNum", secondNum);
                activityIntent.putExtras(newActivityInfo);
                startActivity(activityIntent);
            }
        });

        btnGoTo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(activityIntent);
            }
        });
    }
}
