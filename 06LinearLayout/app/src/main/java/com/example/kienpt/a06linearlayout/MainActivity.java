package com.example.kienpt.a06linearlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvColor;
    private RadioButton rdRed;
    private RadioButton rdWhite;
    private Button btnSetColor;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        btnSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvColor.setBackgroundColor(Color.BLACK);
            }
        });
    }

    private void connectView() {
        tvColor = (TextView) findViewById(R.id.tv_color);
        rdRed = (RadioButton) findViewById(R.id.rd_red);
        rdWhite = (RadioButton) findViewById(R.id.rd_white);
        btnSetColor = (Button) findViewById(R.id.btn_setColor);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }

    // change color when button is clicked
    private void changeColor() {
        if (rdRed.isChecked()) {
            tvColor.setBackgroundColor(Color.RED);
        } else if (rdWhite.isChecked()) {
            tvColor.setBackgroundColor(Color.WHITE);
        } else {
            tvColor.setBackgroundColor(Color.BLUE);
        }
    }
}
