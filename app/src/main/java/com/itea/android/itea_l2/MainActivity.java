package com.itea.android.itea_l2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etInPassword;

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
        rbHandler;
        rbAsyncTask;
        bHack;
        cbRun;
        pb;
        tvTime;
        tvPassword;
        tvInfo;
    }
}