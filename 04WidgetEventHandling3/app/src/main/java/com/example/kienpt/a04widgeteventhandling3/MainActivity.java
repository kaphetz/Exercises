package com.example.kienpt.a04widgeteventhandling3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickHello(View v) {
        String text = "HELLO";
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    public void ClickGoodbye(View v) {
        String text = "GOODBYE";
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
