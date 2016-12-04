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

    private String sName;
    private String sLName;
    private String sMail;

    private EditText eName;
    private EditText eLName;
    private EditText eMail;

    private CheckBox cbAvto;
    private CheckBox cbCCard;

    private CheckBox cbJava;
    private CheckBox cbAndroid;
    private CheckBox cbJavaEE;
    private CheckBox cbC;
    private CheckBox cbPHP;
    private CheckBox cbOther;

    private RadioButton rbFrelance;
    private RadioButton rbFulltime;
    private RadioButton rbRemote;
    private RadioButton rbOther;

    private Button bSend;
    private Button bCancel;
    private Button bLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.eName);
        eLName = (EditText) findViewById(R.id.eLName);
        eMail = (EditText) findViewById(R.id.eMail);

        cbAvto = (CheckBox) findViewById(R.id.cbAvto);
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

        bSend = (Button) findViewById(R.id.bSend);
        bCancel = (Button) findViewById(R.id.bCancel);
        bLater = (Button) findViewById(R.id.bLater);

        /**связываем переменную eName с view-элементом
         * подключаем слушатель*/
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

        /**связываем переменную eLName с view-элементом
         * подключаем слушатель*/
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

        /**связываем переменную eMail с view-элементом
         * подключаем слушатель*/
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

        /**включаем слушатель на кнопку */
        bSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (personalData()) {
                    Toast.makeText(MainActivity.this, "financial stability: " + selectPersonalData() + ", " + "skills: " + selectSkills() + "; " + "work schedule: " + selectWork(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /**метод проверяет заполнение персональных данных
     * @return
     */
    private boolean personalData() {
        if (!sName.equals("")) {
            if (!sLName.equals("")) {
                if (!sMail.equals("")) {
                    Toast.makeText(MainActivity.this, "Name: " + sName + " Last name: " + sLName + " eMail: " + sMail, Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    eMail.requestFocus();
                    Toast.makeText(MainActivity.this, "укажите Email пользователя", Toast.LENGTH_SHORT).show();
                }
            } else {
                eLName.requestFocus();
                Toast.makeText(MainActivity.this, "укажите Last name пользователя", Toast.LENGTH_SHORT).show();
            }
        } else {
            eName.requestFocus();
            Toast.makeText(MainActivity.this, "укажите Name пользователя", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    /**формируем personal
     * через "," перечисляем выбранные элементы
     * @return
     */
    private String selectPersonalData() {
        StringBuilder personal = new StringBuilder();
        if (cbAvto.isChecked())
            personal.append(cbAvto.getText());
        if (cbCCard.isChecked()) {
            if (personal.length() > 0)
                personal.append(", ");
            personal.append(cbCCard.getText());
        }
        if (personal.length() == 0)
            personal.append("No");
        return String.valueOf(personal);
    }

    /**формируем skills
     * через "," перечисляем выбранные элементы колонки "Skills"
     * @return
     */
    private String selectSkills() {
        StringBuilder skills = new StringBuilder();
        if (cbJava.isChecked())
            skills.append(cbJava.getText());
        if (cbAndroid.isChecked()) {
            if (skills.length() > 0)
                skills.append(", ");
            skills.append("" + cbAndroid.getText());
        }
        if (cbJavaEE.isChecked()) {
            if (skills.length() > 0)
                skills.append(", ");
            skills.append(cbJavaEE.getText());
        }
        if (cbC.isChecked()) {
            if (skills.length() > 0)
                skills.append(", ");
            skills.append(cbC.getText());
        }
        if (cbPHP.isChecked()) {
            if (skills.length() > 0)
                skills.append(", ");
            skills.append(cbPHP.getText());
        }
        if (cbOther.isChecked()) {
            if (skills.length() > 0)
                skills.append(", ");
            skills.append(cbOther.getText());
        }

        if (skills.length() == 0)
            skills.append("No");

        return String.valueOf(skills);
    }

    /**проверка выбран ли элемент с колонки "Work schedule"
     * @return
     */
    private String selectWork(){
        rbOther.setChecked(true);

        String workSchedule = "";
        if (rbFrelance.isChecked())
            workSchedule = "" + rbFrelance.getText();
        if (rbFulltime.isChecked())
            workSchedule = "" + rbFulltime.getText();
        if (rbRemote.isChecked())
            workSchedule = "" + rbRemote.getText();
        if (rbOther.isChecked())
            workSchedule = "" + rbOther.getText();
        return String.valueOf(workSchedule);
    }
}
