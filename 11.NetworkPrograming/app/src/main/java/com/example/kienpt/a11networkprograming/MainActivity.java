package com.example.kienpt.a11networkprograming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
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

        // print out the number of lines
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlString = mEtURL.getText().toString();
                // Check URL string is empty or not
                if (TextUtils.isEmpty(urlString)) {
                    mEtURL.setError("You didn't enter a URL");
                    return;
                }
                /* if (!URLUtil.isValidUrl(urlString)) {
                    etUrl.setError("This URL is invalid");
                    return;
                }*/
                //Trigger the process
                new MyAsyncTask(MainActivity.this).execute(mEtURL.getText().toString());
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
