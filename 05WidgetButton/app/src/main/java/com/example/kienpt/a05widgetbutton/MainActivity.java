package com.example.kienpt.a05widgetbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton ibtnRed;
    private ImageButton ibtnBlue;
    private TextView tvShowColor;
    private RadioGroup rdgColor;
    private RadioGroup rdgColor2;
    private ToggleButton tbRed;
    private ToggleButton tbYellow;
    private ToggleButton tbBlue;
    private Button btnSetColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectView();
        ibtnRed.setOnClickListener(new ChangeColorByImageButton(Color.RED));
        ibtnBlue.setOnClickListener(new ChangeColorByImageButton(Color.BLUE));

        rdgColor.setOnCheckedChangeListener(new RadioGroupInfo());

        tbRed.setOnClickListener(new ChangeColorByToggleButton());
        tbYellow.setOnClickListener(new ChangeColorByToggleButton());
        tbBlue.setOnClickListener(new ChangeColorByToggleButton());

        // Change the color when  Button is clicked
        btnSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rdgColor2.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.rd_red2:
                        tvShowColor.setBackgroundColor(Color.RED);
                        break;
                    case R.id.rd_yellow2:
                        tvShowColor.setBackgroundColor(Color.YELLOW);
                        break;
                    case R.id.rd_blue2:
                        tvShowColor.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        });
    }

    private void connectView() {
        ibtnRed = (ImageButton) findViewById(R.id.ibtn_red);
        ibtnBlue = (ImageButton) findViewById(R.id.ibtn_blue);
        tvShowColor = (TextView) findViewById(R.id.tv_showColor);
        rdgColor = (RadioGroup) findViewById(R.id.rdg_color);
        rdgColor2 = (RadioGroup) findViewById(R.id.rdg_color2);
        tbRed = (ToggleButton) findViewById(R.id.tbtn_red);
        tbYellow = (ToggleButton) findViewById(R.id.tbtn_yellow);
        tbBlue = (ToggleButton) findViewById(R.id.tbtn_blue);
        btnSetColor = (Button) findViewById(R.id.btn_setColor);
    }

    // Change color when image button is clicked
    private class ChangeColorByImageButton implements View.OnClickListener {
        private int mColor;

        private ChangeColorByImageButton(int color) {
            mColor = color;
        }

        @Override
        public void onClick(View v) {
            tvShowColor.setBackgroundColor(mColor);
        }
    }

    // Change color when toggle button is clicked
    private class ChangeColorByToggleButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            StringBuffer result = new StringBuffer();
            result.append(((ToggleButton) v).getText());
            if (!tbRed.getText().equals("Red") &&
                    !tbYellow.getText().equals("Yellow") &&
                    !tbBlue.getText().equals("Blue")) {
                tvShowColor.setBackgroundColor(Color.BLACK);
            }
            switch (result.toString()) {
                case "Red":
                    tvShowColor.setBackgroundColor(Color.RED);
                    break;
                case "Yellow":
                    tvShowColor.setBackgroundColor(Color.YELLOW);
                    break;
                case "Blue":
                    tvShowColor.setBackgroundColor(Color.BLUE);
                    break;
            }
        }
    }

    // Change color when click radio button is clicked
    private class RadioGroupInfo implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton newChecked = (RadioButton) findViewById(checkedId);
            switch (String.valueOf(newChecked.getText())) {
                case "Red":
                    tvShowColor.setBackgroundColor(Color.RED);
                    break;
                case "Yellow":
                    tvShowColor.setBackgroundColor(Color.YELLOW);
                    break;
                default:
                    tvShowColor.setBackgroundColor(Color.BLUE);
            }
        }
    }
}
