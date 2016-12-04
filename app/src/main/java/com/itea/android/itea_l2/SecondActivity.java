package com.itea.android.itea_l2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Ev on 04.12.2016.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent secondIntent = getIntent();
        Bundle b = secondIntent.getExtras();
        String s = b.getString(Constants.KEY, "NO_VALUE");
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Second Activity", Toast.LENGTH_SHORT).show();

    }
}