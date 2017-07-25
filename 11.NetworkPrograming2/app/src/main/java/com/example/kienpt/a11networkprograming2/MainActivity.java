package com.example.kienpt.a11networkprograming2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button mBtnPrint;
    private EditText mEtUrl;
    private TextView mTvResult;
    private TextView mTvError;
    private int mLineSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPrint = (Button) findViewById(R.id.btn_printOut);
        mEtUrl = (EditText) findViewById(R.id.et_url);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mTvError = (TextView) findViewById(R.id.tv_error);

        mBtnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String urlString = mEtUrl.getText().toString();
                showResults();
                mTvResult.setText(mLineSum);
            }
        });
    }

    private void showResults() {
        try {
            String urlBody = HttpUtils.urlContent("http://apps.coreservlets.com/NetworkingSupport/loan-calculator");
            String[] lines = urlBody.split("[\\n\\r]+");
            mLineSum = lines.length;
        } catch (MalformedURLException e) {
            showError("Bad URL: ");
            e.printStackTrace(); // View this in DDMS window
        } catch (IOException e) {
            showError("Error in connection: " + e);
            e.printStackTrace(); // View this in DDMS window
        }
    }

    private void showError(String text) {
        mTvError.setText(String.format("\n\n%s", text));
    }
}
