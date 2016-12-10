package com.itea.android.itea_l2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // проверка логина и пароля

                Intent intent = new Intent(MainActivity.this, PersonActivity.class);
                //intent.putExtra(Constants.KEY, etLogin.getText().toString());
                startActivity(intent);
                // передать логин и вывести его в тулбаре следующего окна

                // finish activity 1
                finish();
            }
        });
    }
}
