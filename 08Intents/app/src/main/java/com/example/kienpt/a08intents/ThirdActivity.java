package com.example.kienpt.a08intents;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import java.util.Random;

@SuppressWarnings("deprecation")
public class ThirdActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TabHost host = getTabHost();
        String baseAddress = "sum://example.com/add";

        //invoke the SumActivity by class name, with no data
        Intent intent1 = new Intent(this, SecondActivity.class);
        TabSpec tab1Spec = host.newTabSpec("First Tab").setIndicator("Tab 1").setContent(intent1);
        host.addTab(tab1Spec);

        //invoke the SumActivity by class name, with randomized “extras” data
        Intent intent2 = new Intent(this, SecondActivity.class);
        Bundle activityInfo = new Bundle();
        Random rand = new Random();
        activityInfo.putInt("firstNum", rand.nextInt(100));
        activityInfo.putInt("secondNum", rand.nextInt(100));
        intent2.putExtras(activityInfo);
        TabSpec tab2Spec = host.newTabSpec("Second Tab").setIndicator("Tab 2").setContent(intent2);
        host.addTab(tab2Spec);

        //invoke the SumActivity by URI, with no data
        Uri uri = Uri.parse(baseAddress);
        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri);
        TabSpec tab3Spec = host.newTabSpec("Third Tab").setIndicator("Tab 3").setContent(intent3);
        host.addTab(tab3Spec);

        //invoke the SumActivity by URI, with randomized URI parameters
        String dataAddress = String.format("%s?firstNum=%s&secondNum=%s", baseAddress,
                rand.nextInt(100), rand.nextInt(100));
        Uri uri1 = Uri.parse(dataAddress);
        Intent intent4 = new Intent(Intent.ACTION_VIEW, uri1);
        TabSpec tab4Spec = host.newTabSpec("Fourth Tab").setIndicator("Tab 4").setContent(intent4);
        host.addTab(tab4Spec);
    }
}
