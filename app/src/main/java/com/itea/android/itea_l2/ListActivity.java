package com.itea.android.itea_l2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lvListContacts;
    private LVAdapter adapter;
    private List<POJO> l;

    private Button bBack;
    private Button bClose;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        bBack = (Button) findViewById(R.id.bBack);
        bClose = (Button) findViewById(R.id.bClose);

        if (getIntent().getExtras() != null) {

            // принимаем обьект POJO
            POJO pojo = getIntent().getExtras().getParcelable(Constants.KEY);

            // подключаем адаптер
            lvListContacts = (ListView) findViewById(R.id.lvListContacts);
            adapter = new LVAdapter(this, R.layout.each_item_list);
            lvListContacts.setAdapter(adapter);

            // создаем ArrayList и записываем туда полученный POJO
            l = new ArrayList<POJO>();
            l.add(pojo);

            // обновляем список
            adapter.updateList(l);
        }

        // удаление элементов списка
        lvListContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder adBuilder = new AlertDialog.Builder(ListActivity.this);

                adBuilder.setCancelable(false);
                adBuilder.setTitle("Внимание");
                adBuilder.setMessage("Вы действительно хотите удалить контакт?");

                adBuilder.setNegativeButton(Constants.BUTTON_NO, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                        .setPositiveButton(Constants.BUTTON_OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                l.remove(position);
                                adapter.updateList(l);
                            }
                        });

                adBuilder.show();

                return false;
            }
        });

        // вернуться назад
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, PersonActivity.class);
                setResult(RESULT_OK, intent);
                //startActivity(intent);
                finish();
            }
        });

        // закрыть
        bClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

