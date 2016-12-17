package com.itea.android.itea_l2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getSharedPreferences(Constants.FILE_SAVE, MODE_PRIVATE);
        String answer = sharedPref.getString(Constants.KEY_SAVE, "");
        if (!answer.equals("not_remember")) {
            Intent intent = new Intent(MainActivity.this, PersonActivity.class);
            intent.putExtra(Constants.KEY, answer);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
