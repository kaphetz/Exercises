package com.example.kienpt.a11networkprograming;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    MyAsyncTask mytt;

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
//                ConnectivityManager cm =
//                        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//                NetworkInfo netInfo = cm.getActiveNetworkInfo();
//                if (netInfo != null && netInfo.isConnectedOrConnecting()) {
//                    mTvResult.setText("Co ket noi mang");
//                }else {
//                    mTvResult.setText("ko Co ket noi mang");
//                }
                showResults();;
            }
        });
    }



    /*
     *Count the number of line at the page in URL
     */
    private void showResults() {
        //truyền this (chính là MainActivity hiện tại) qua Child Thread
        mytt =new MyAsyncTask(this);
        //Kích hoạt Tiến trình
        //khi gọi hàm này thì onPreExecute của mytt sẽ thực thi trước
        mytt.execute();
//        HttpURLConnection urlConnection = null;
//        try {
//            URL url = new URL("http://apps.coreservlets.com/NetworkingSupport/loan-calculator");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream());
//            BufferedReader in = new BufferedReader(inputStream);
//            while (in.readLine() != null) {
//                mLineSum++;
//            }
//        } catch (MalformedURLException e) {
//            showError("Bad URL: ");
//            e.printStackTrace(); // View this in DDMS window
//        } catch (IOException e) {
//            showError("Error in connection: " + e);
//            e.printStackTrace(); // View this in DDMS window
//        } finally {
//            assert urlConnection != null;
//            urlConnection.disconnect();
//        }
    }


}
