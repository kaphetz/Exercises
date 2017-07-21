package com.example.kienpt.a05spinner;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spnColorXML = (Spinner) findViewById(R.id.spn_colorXML);
        Spinner spnColorJava = (Spinner) findViewById(R.id.spn_colorJava);
        mTvColor = (TextView) findViewById(R.id.tv_color);
        spnColorXML.setOnItemSelectedListener(new SpinnerInfo());

        String[] listColor = {"Red", "Yellow", "Blue", "Green"};
        ArrayAdapter<String> spinner2Adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listColor);
        spinner2Adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spnColorJava.setAdapter(spinner2Adapter);
        spnColorJava.setOnItemSelectedListener(new SpinnerInfo());

    }

    /*-
     *Event select color from spinner
     */
    private class SpinnerInfo implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> spinner, View selectedView,
                                   int selectedIndex, long id) {
            String selectedColor = spinner.getItemAtPosition(selectedIndex).toString();
            switch (selectedColor) {
                case "Red":
                    mTvColor.setBackgroundColor(Color.RED);
                    break;
                case "Yellow":
                    mTvColor.setBackgroundColor(Color.YELLOW);
                    break;
                case "Blue":
                    mTvColor.setBackgroundColor(Color.BLUE);
                    break;
                default:
                    mTvColor.setBackgroundColor(Color.GREEN);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> spinner) {
            //do something
        }
    }
}
