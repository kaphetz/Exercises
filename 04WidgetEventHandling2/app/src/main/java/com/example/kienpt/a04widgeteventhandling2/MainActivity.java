package com.example.kienpt.a04widgeteventhandling2;

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
        btnHello.setOnClickListener(new ShowToast("Hello", this));
        btnGoodBye.setOnClickListener(new ShowToast("Goodbye", this));
    }

    private class ShowToast implements View.OnClickListener {
        private String mText;
        private MainActivity mMainActivity;

        private ShowToast(String text, MainActivity mainActivity) {
            mText = text;
            mMainActivity = mainActivity;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, mText.toUpperCase(), Toast.LENGTH_SHORT).show();
        }
    }
}
