package com.itea.android.itea_l2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText eName;
    protected EditText eLName;
    protected EditText eMail;

    private String sName;
    private SpannableStringBuilder stringBuilder;

    protected CheckBox cbAuto;
    protected CheckBox cbCCard;

    protected CheckBox cbJava;
    protected CheckBox cbAndroid;
    protected CheckBox cbJavaEE;
    protected CheckBox cbC;
    protected CheckBox cbPHP;
    protected CheckBox cbOther;

    protected RadioButton rbFrelance;
    protected RadioButton rbFulltime;
    protected RadioButton rbRemote;
    protected RadioButton rbOther;

    protected Button bSend;
    protected Button bCancel;
    protected Button bLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.eName);
        eName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                stringBuilder = (SpannableStringBuilder) charSequence;
                sName = stringBuilder.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        eLName = (EditText) findViewById(R.id.eLName);

        eMail = (EditText) findViewById(R.id.eMail);

        cbAuto = (CheckBox) findViewById(R.id.cbAuto);
        cbAuto.isChecked();

        cbCCard = (CheckBox) findViewById(R.id.cbCCard);
        cbAuto.isChecked();

        bSend = (Button) findViewById(R.id.bSend);
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sName.matches(""))
                Toast.makeText(MainActivity.this, sName, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "укажите имя пользователя", Toast.LENGTH_SHORT).show();
            }
        });

        bCancel = (Button) findViewById(R.id.bCancel);
        bLater = (Button) findViewById(R.id.bLater);

    }
}
