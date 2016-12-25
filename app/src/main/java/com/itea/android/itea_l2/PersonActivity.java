package com.itea.android.itea_l2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PersonActivity extends AppCompatActivity {

    ImageView ivPerson;

    EditText etName;
    EditText etLName;
    EditText etPNumber;
    EditText etCountry;
    EditText etCity;
    EditText etEmail;
    EditText etNotes;

    Button bCancel;
    Button bClear;
    Button bSkip;
    Button bOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        ivPerson = (ImageView) findViewById(R.id.ivPerson);

        etName = (EditText) findViewById(R.id.etName);
        etLName = (EditText) findViewById(R.id.etLName);
        etPNumber = (EditText) findViewById(R.id.etPNumber);
        etCountry = (EditText) findViewById(R.id.etCountry);
        etCity = (EditText) findViewById(R.id.etCity);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etNotes = (EditText) findViewById(R.id.etNotes);

        bCancel = (Button) findViewById(R.id.bCancel);
        bClear = (Button) findViewById(R.id.bClear);
        bSkip = (Button) findViewById(R.id.bSkip);
        bOk = (Button) findViewById(R.id.bOk);

        //получаем логин с активити 1 и передаем его в ToolBar
        String s = getIntent().getExtras().getString(Constants.KEY);
        getSupportActionBar().setTitle(s);

        // если курсор в этом поле, отображается +38
        etPNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    if (etPNumber.getText().toString().equals("")) {
                        etPNumber.setText("+38");
                        etPNumber.setSelection(etPNumber.getText().length());
                    }
                }

                if (!hasFocus && (etPNumber.getText().toString().equals("+38")))
                    etPNumber.setText("");
            }

        });

        // выход с приложения
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // очистить все поля
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ivPerson загрузить базовый рисунок
                etName.setText("");
                etLName.setText("");
                etPNumber.setText("");
                etCountry.setText("");
                etCity.setText("");
                etEmail.setText("");
                etNotes.setText("");
            }
        });

        // пропустить форму заполнения и перейти в следующую активность
        bSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                if (ValidInput.validBSkip(etName)) i++;
                if (ValidInput.validBSkip(etLName)) i++;
                if (ValidInput.validBSkip(etPNumber)) i++;
                if (ValidInput.validBSkip(etCountry)) i++;
                if (ValidInput.validBSkip(etCity)) i++;
                if (ValidInput.validBSkip(etEmail)) i++;
                if (ValidInput.validBSkip(etNotes)) i++;

                if (i == 7) {
                    Intent intent = new Intent(PersonActivity.this, ListActivity.class);
                    startActivity(intent);
                }
            }
        });

        // принять форму и перейти дальше
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                //считываем с полей данные
                String sImage = "";
                String sName = etName.getText().toString();
                String sLName = etLName.getText().toString();
                String sPNumber = etPNumber.getText().toString();
                String sCountry = etCountry.getText().toString();
                String sCity = etCity.getText().toString();
                String sEmail = etEmail.getText().toString();
                String sNotes = etNotes.getText().toString();

                if (!ValidInput.validName(sName)) {
                    etName.setError("error input name");
                    etName.requestFocus();
                    i = 1;
                }
                if (!ValidInput.validLName(sLName)) {
                    etLName.setError("error input last name");
                    etLName.requestFocus();
                    i = 1;
                }
                if (!ValidInput.validPNumber(sPNumber)) {
                    etPNumber.setError("error input number phone");
                    etPNumber.requestFocus();
                    i = 1;
                }

                if (!ValidInput.validCountry(sCountry)) {
                    etCountry.setError("error input country");
                    etCountry.requestFocus();
                    i = 1;
                }
                if (!ValidInput.validCity(sCity)) {
                    etCity.setError("error input city");
                    etCity.requestFocus();
                    i = 1;
                }
                if (!ValidInput.validEmail(sEmail)) {
                    etEmail.setError("error input email");
                    etEmail.requestFocus();
                    i = 1;
                }
                if (!ValidInput.validNotes(sNotes)) {
                    etNotes.setError("error input notes");
                    etNotes.requestFocus();
                    i = 1;
                }

                // создаем объект с введенными параметрами, передаем его в следующую активность
                if (i != 1) {
                    Intent intent = new Intent(PersonActivity.this, ListActivity.class);
                    intent.putExtra(Constants.KEY, new POJO(sImage, sName, sLName, sPNumber, sCountry, sCity, sEmail, sNotes));
                    startActivityForResult(intent, Constants.REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*if (data == null)
            return;*/

        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == RESULT_OK)
                Toast.makeText(PersonActivity.this, "not_error", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(PersonActivity.this, "eror", Toast.LENGTH_SHORT).show();
        }

    }
}
