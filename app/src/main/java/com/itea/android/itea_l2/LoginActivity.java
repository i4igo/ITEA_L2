package com.itea.android.itea_l2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**проверка логина и пароля
                 *  передать логин и вывести его в тулбаре следующей активности
                 *  открыть новую активность и закрыть эту
                 * при ошибках ввода, заставить исправить их
                 */
                if (ValidInput.validLogin(etLogin.getText().toString())) {
                    String login = etLogin.getText().toString();

                    if (ValidInput.validPassword(etPassword.getText().toString())) {

                        Intent intent = new Intent(LoginActivity.this, PersonActivity.class);
                        intent.putExtra(Constants.KEY, login);
                        startActivity(intent);
                        finish();

                    } else {
                        etPassword.requestFocus();
                        etPassword.setError("Check your password");
                    }
                } else {
                    etLogin.requestFocus();
                    etLogin.setError("Check your email");
                }
            }
        });
    }
}
