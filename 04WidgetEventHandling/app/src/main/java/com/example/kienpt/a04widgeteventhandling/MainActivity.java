package com.example.kienpt.a04widgeteventhandling;

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
        Button btnHello = (Button) findViewById(R.id.btn_hello);
        Button btnGoodBye = (Button) findViewById(R.id.btn_goodbye);
        btnHello.setOnClickListener(new ShowToast("HELLO"));
        btnGoodBye.setOnClickListener(new ShowToast("GOODBYE"));
    }

    //show toast when button is clicked
    private class ShowToast implements View.OnClickListener {
        private String mText;

        private ShowToast(String text) {
            mText = text;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, mText, Toast.LENGTH_SHORT).show();
        }
    }
}
