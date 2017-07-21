package com.example.kienpt.a08intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnGoTo1 = (Button) findViewById(R.id.btnGoTo1);
        TextView tvSum = (TextView) findViewById(R.id.tv_sum);
        Intent intent = getIntent();
        Bundle info = intent.getExtras();
        int a = 5, b = 3, sum = a + b;
        if (info != null) {
            a = info.getInt("a");
            b = info.getInt("b");
            sum = a + b;
        }
        tvSum.setText("The sum of " + String.valueOf(a) + " and " + String.valueOf(b) + " is " +
                String.valueOf(sum));
        btnGoTo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(activityIntent);
            }
        });
    }
}
