package com.itea.android.itea_l2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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
        bSkip = (Button) findViewById(R.id.bSkip);
        bOk = (Button) findViewById(R.id.bOk);

        //получаем данные с активити 1
        Intent secondIntent = getIntent();
        Bundle b = secondIntent.getExtras();
        //получаем логин и передаем его в ToolBar
        String s = b.getString(Constants.KEY, "NO_VALUE");
        getSupportActionBar().setTitle(s);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //считываем с полей данные

                //String sImage = ;
                String sName = etName.getText().toString();
                String sLName = etLName.getText().toString();
                String sPNumber = etPNumber.getText().toString();
                String sCountry = etCountry.getText().toString();
                String sCity = etCity.getText().toString();
                String sEmail = etEmail.getText().toString();
                String sNotes = etNotes.getText().toString();


                Intent intent = new Intent(PersonActivity.this, ListActivity.class);
                //intent.putExtra(Constants.KEY, new POJO(sImage, sName, sLName, sPNumber, sCountry, sCity, sEmail, sNotes));
                startActivity(intent);
            }
        });
    }
}