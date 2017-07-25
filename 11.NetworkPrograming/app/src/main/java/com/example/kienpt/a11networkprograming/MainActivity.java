package com.example.kienpt.a11networkprograming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyAsyncTask mMyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnPrint = (Button) findViewById(R.id.btn_printOut);

        mBtnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResults();
            }
        });
    }

    /*
     *Count the number of line at the page in URL
     */
    private void showResults() {
        mMyTask = new MyAsyncTask(this);
        mMyTask.execute();
    }


}
