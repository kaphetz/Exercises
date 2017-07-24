package com.example.kienpt.a10rotationsandapprestarts;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llMessage;
    private EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAddMessage = (Button) findViewById(R.id.btn_add_message);
        etMessage = (EditText) findViewById(R.id.et_message);
        llMessage = (LinearLayout) findViewById(R.id.ll_message);

        //Read data out of Bundle in onRestoreInstanceState
        if (savedInstanceState != null) {
            ArrayList<String> savedData = savedInstanceState.getStringArrayList("data");
            if (savedData != null) {
                for (int i = 0; i < savedData.size(); i++) {
                    TextView tvShowMessage = new TextView(MainActivity.this);
                    LinearLayout.LayoutParams params =
                            new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                                    ActionBar.LayoutParams.WRAP_CONTENT);
                    params.setMargins(10, 10, 10, 10);
                    tvShowMessage.setLayoutParams(params);
                    tvShowMessage.setText(savedData.get(i));
                    llMessage.addView(tvShowMessage);
                }
            }
        }

        btnAddMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // return error if edit text empty
                if (TextUtils.isEmpty(etMessage.getText().toString())) {
                    etMessage.setError("Please enter a short string");
                } else {
                    // add message into text view
                    TextView tvShowMessage = new TextView(MainActivity.this);
                    LinearLayout.LayoutParams params =
                            new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                                    ActionBar.LayoutParams.WRAP_CONTENT);
                    params.setMargins(10, 10, 10, 10);
                    tvShowMessage.setLayoutParams(params);
                    tvShowMessage.setText(etMessage.getText().toString());
                    llMessage.addView(tvShowMessage);
                }
            }
        });
    }

    /*
     *Save data in a Bundle in onSaveInstanceState
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        ArrayList<String> arrayMessage = new ArrayList<>();
        for (int i = 2; i < llMessage.getChildCount(); i++) {
            TextView children = (TextView) llMessage.getChildAt(i);
            String mess = children.getText().toString();
            arrayMessage.add(mess);
        }
        savedInstanceState.putStringArrayList("data", arrayMessage);
    }
}
