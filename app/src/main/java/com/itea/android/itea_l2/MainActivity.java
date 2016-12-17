package com.itea.android.itea_l2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bTest;
    //    private LvAdapterTest adapter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bTest = (Button) findViewById(R.id.bTest);


        if (savedInstanceState != null && savedInstanceState.containsKey("count")) {
            count = savedInstanceState.getInt("count");
        }

        bTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                Toast.makeText(MainActivity.this, ""+ count, Toast.LENGTH_SHORT).show();
            }
        });

        Log.wtf("act_life", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.wtf("act_life", "onStart");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey("count")) {
            count = savedInstanceState.getInt("count");
        }
        super.onRestoreInstanceState(savedInstanceState);
        Log.wtf("act_life", "onRestoreInstanceState");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.wtf("act_life", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.wtf("act_life", "onPause");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("count", count);
        super.onSaveInstanceState(outState);
        Log.wtf("act_life", "onSaveInstanceState");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.wtf("act_life", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.wtf("act_life", "onDestroy");

    }
}
