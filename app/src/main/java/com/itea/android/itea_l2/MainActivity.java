package com.itea.android.itea_l2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String sName, sLName, sMail;

    private EditText eName, eLName, eMail;

    private CheckBox cbAuto, cbCCard;

    private CheckBox cbJava;
    private CheckBox cbAndroid;
    private CheckBox cbJavaEE;
    private CheckBox cbC;
    private CheckBox cbPHP;
    private CheckBox cbOther;
    private StringBuilder skills;

    private RadioButton rbFrelance;
    private RadioButton rbFulltime;
    private RadioButton rbRemote;
    private RadioButton rbOther;
    private String workSchedule;

    private Button bSend, bCancel, bLater;

    private StringBuilder personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* связываем переменную с view-элементом
        *  подключаем слушатель*/
        eName = (EditText) findViewById(R.id.eName);
        //eName.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        sName = eName.getText().toString();
        eName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sName = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /* связываем переменную с view-элементом
        *  подключаем слушатель*/
        eLName = (EditText) findViewById(R.id.eLName);
        sLName = eLName.getText().toString();
        eLName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sLName = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /* связываем переменную с view-элементом
        *  подключаем слушатель*/
        eMail = (EditText) findViewById(R.id.eMail);
        sMail = eMail.getText().toString();
        eMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sMail = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cbAuto = (CheckBox) findViewById(R.id.cbAuto);
        cbCCard = (CheckBox) findViewById(R.id.cbCCard);

        cbJava = (CheckBox) findViewById(R.id.cbJava);
        cbAndroid = (CheckBox) findViewById(R.id.cbAndroid);
        cbJavaEE = (CheckBox) findViewById(R.id.cbJavaEE);
        cbC = (CheckBox) findViewById(R.id.cbC);
        cbPHP = (CheckBox) findViewById(R.id.cbPHP);
        cbOther = (CheckBox) findViewById(R.id.cbOther);

        rbFrelance = (RadioButton) findViewById(R.id.rbFrelance);
        rbFulltime = (RadioButton) findViewById(R.id.rbFulltime);
        rbRemote = (RadioButton) findViewById(R.id.rbRemote);
        rbOther = (RadioButton) findViewById(R.id.rbOther);

        /* включаем слушатель на кнопку*/
        personal = new StringBuilder();
        bSend = (Button) findViewById(R.id.bSend);
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sName.equals("")) {
                    if (!sLName.equals(""))
                        if (!sMail.equals(""))
                            Toast.makeText(MainActivity.this, "Name: " + sName + " Last name: " + sLName + " eMail: " + sMail, Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "укажите eMail пользователя", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "укажите last name пользователя", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "укажите name пользователя", Toast.LENGTH_SHORT).show();

//                personal.append("у пользователя есть: ");

                if(cbAuto.isChecked())
//                    personal.append(cbAuto.getText().toString());
                    //Toast.makeText(MainActivity.this, "у пользователя есть " + cbAuto.getText(), Toast.LENGTH_SHORT).show();

                if(cbCCard.isChecked())
//                    personal.append(cbCCard.getText());
                    //Toast.makeText(MainActivity.this, "у пользователя есть " + cbCCard.getText(), Toast.LENGTH_SHORT).show();

//                String sss = personal.toString();

//                Toast.makeText(MainActivity.this, "у пользователя есть " + sss, Toast.LENGTH_SHORT).show();

                if (cbJava.isChecked())
                    skills.append(cbJava.getText());
                if (cbAndroid.isChecked())
                    skills.append("" + cbAndroid.getText());
                if (cbJavaEE.isChecked())
                    skills.append(cbJavaEE.getText());
                if (cbC.isChecked())
                    skills.append(cbC.getText());
                if (cbPHP.isChecked())
                    skills.append(cbPHP.getText());
                if (cbOther.isChecked())
                    skills.append(cbOther.getText());

                if (rbFrelance.isChecked())
                    workSchedule = "" + rbFrelance.getText();
                if (rbFulltime.isChecked())
                    workSchedule = "" + rbFulltime.getText();
                if (rbRemote.isChecked())
                    workSchedule = "" + rbRemote.getText();
                if (rbOther.isChecked())
                    workSchedule = "" + rbOther.getText();

                Toast.makeText(MainActivity.this, "skills: " + skills + ", " + "work schedule: " + workSchedule, Toast.LENGTH_SHORT).show();
            }
        });

        bCancel = (Button) findViewById(R.id.bCancel);
        bLater = (Button) findViewById(R.id.bLater);

    }
}
