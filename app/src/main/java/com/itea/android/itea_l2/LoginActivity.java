package com.itea.android.itea_l2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private CheckBox cbRemember;
    private Button bLogin;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**проверка логина и пароля
                 *  передать логин и вывести его в тулбаре следующей активности
                 *  открыть новую активность и закрыть эту
                 * при ошибках ввода, заставить исправить их
                 */

                int i = 0;
                String login = "";

                if (ValidInput.validLogin(etLogin)) {
                    i++;
                    login = etLogin.getText().toString();
                }

                if (ValidInput.validPassword(etPassword)) i++;
                else if (login.length() != 0)
                    etPassword.requestFocus();

                sharedPref = getSharedPreferences(Constants.FILE_SAVE, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                if (cbRemember.isChecked()) {
                    editor.putString(Constants.KEY_SAVE, login);
                    editor.commit();
                } else {
                    editor.putString(Constants.KEY_SAVE, Constants.KEY_NOT_SAVE);
                    editor.commit();
                }

                if (i == 2) {
                    Intent intent = new Intent(LoginActivity.this, PersonActivity.class);
                    intent.putExtra(Constants.KEY, login);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
