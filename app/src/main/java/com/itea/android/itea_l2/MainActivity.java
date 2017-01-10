package com.itea.android.itea_l2;

import android.os.AsyncTask;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInPassword;
    private RadioGroup rgMode;
    private RadioButton rbHandler;
    private RadioButton rbAsyncTask;
    private Button bHack;
    private CheckBox cbRun;
    private ProgressBar pb;
    private TextView tvTime;
    private TextView tvPassword;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInPassword = (EditText) findViewById(R.id.etInPassword);
        rgMode = (RadioGroup) findViewById(R.id.rgMode);
        rbHandler = (RadioButton) findViewById(R.id.rbHandler);
        rbAsyncTask = (RadioButton) findViewById(R.id.rbAsyncTask);
        bHack = (Button) findViewById(R.id.bHack);
        cbRun = (CheckBox) findViewById(R.id.cbRun);
        pb = (ProgressBar) findViewById(R.id.pb);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }

    @Override
    public void onClick(View v) {
        String needToHack = etInPassword.getText().toString();

        switch (rgMode.getCheckedRadioButtonId()) {
            case R.id.rbHandler:


                break;

            case R.id.rbAsyncTask:


                break;
        }
    }

    class TestAsyncTask extends AsyncTask<String, UpdateMessage, Void> {

        // подготавливаем данные
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // создаем новый процесс
        @Override
        protected Void doInBackground(String... params) {

            //передаем данные
            publishProgress();

            return null;
        }

        // получаем данные
        @Override
        protected void onProgressUpdate(UpdateMessage... values) {
            super.onProgressUpdate(values);
        }

        // получаем результат работы
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        // останавливаем обновление данных экрана
        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


    }
}