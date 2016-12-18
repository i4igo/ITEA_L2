package com.itea.android.itea_l2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
                    etName.setError("ошибочка братишка");
                    etName.requestFocus();
                }

                ValidInput.validLName(sLName);
                ValidInput.validPNumber(sPNumber);
                ValidInput.validCountry(sCountry);
                ValidInput.validCity(sCity);
                ValidInput.validEmail(sEmail);

                // создаем объект с введенными параметрами, передаем его в следующую активность
                Intent intent = new Intent(PersonActivity.this, ListActivity.class);
                intent.putExtra(Constants.KEY, new POJO(sImage, sName, sLName, sPNumber, sCountry, sCity, sEmail, sNotes));
                startActivityForResult(intent, Constants.REQUEST_CODE);
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