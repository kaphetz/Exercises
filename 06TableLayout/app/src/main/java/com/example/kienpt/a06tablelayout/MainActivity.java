package com.example.kienpt.a06tablelayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnColor1 = (Button) findViewById(R.id.btnColor1);
        Button btnColor2 = (Button) findViewById(R.id.btnColor2);
        Button btnColor3 = (Button) findViewById(R.id.btnColor3);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        mTvColor = (TextView) findViewById(R.id.tvColor);

        btnColor1.setOnClickListener(new ChangeColor(Color.RED));
        btnColor2.setOnClickListener(new ChangeColor(Color.YELLOW));
        btnColor3.setOnClickListener(new ChangeColor(Color.BLUE));
        btnClear.setOnClickListener(new ChangeColor(Color.WHITE));

    }

    //Event change color when button is clicked
    private class ChangeColor implements View.OnClickListener {
        private int mColor;

        private ChangeColor(int color) {
            mColor = color;
        }

        @Override
        public void onClick(View v) {
            mTvColor.setBackgroundColor(mColor);
        }
    }
}
