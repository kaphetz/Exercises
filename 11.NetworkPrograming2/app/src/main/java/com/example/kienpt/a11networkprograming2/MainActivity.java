package com.example.kienpt.a11networkprograming2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText mEtURL;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPrint = (Button) findViewById(R.id.btn_printOut);
        Button btnClear = (Button) findViewById(R.id.btn_clear);
        mEtURL = (EditText) findViewById(R.id.et_url);
        mTvResult = (TextView) findViewById(R.id.tv_result);

        // print out the number of characters
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlString = mEtURL.getText().toString();
                // Check URL string is empty or not
                if (TextUtils.isEmpty(urlString)) {
                    mEtURL.setError("You didn't enter a URL");
                    return;
                }
                MyAsyncTask myTask;
                myTask = new MyAsyncTask(MainActivity.this);
                myTask.execute(mEtURL.getText().toString());
            }
        });

        // clear text of EditText and TextView
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtURL.setText("");
                mTvResult.setText("");
            }
        });
    }


}
