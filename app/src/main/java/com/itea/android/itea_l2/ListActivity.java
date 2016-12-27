package com.itea.android.itea_l2;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView lvListContacts;
    private LVAdapter adapter;
    private ArrayList<POJO> pojoList;

    private Button bBack;
    private Button bClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        bBack = (Button) findViewById(R.id.bBack);
        bClose = (Button) findViewById(R.id.bClose);

        if (getIntent().getExtras() != null) {

        // принимаем обьект ArrayList<POJO>
        pojoList = getIntent().getExtras().getParcelableArrayList(Constants.KEY);

        // подключаем адаптер
        lvListContacts = (ListView) findViewById(R.id.lvListContacts);
        adapter = new LVAdapter(this, R.layout.each_item_list);
        lvListContacts.setAdapter(adapter);

        // обновляем список
        adapter.updateList(pojoList);
        }

        // просмотреть контакт
        if (pojoList != null){
            lvListContacts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //pojoList.
                }
            });
        }

        // удаление элементов списка
        if (pojoList != null) {
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
                                    pojoList.remove(position);
                                    adapter.updateList(pojoList);
                                }
                            });
                    adBuilder.show();
                    return false;
                }
            });
        }

        // вернуться назад
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, PersonActivity.class);
                intent.putExtras(intent).putParcelableArrayListExtra(Constants.KEY, pojoList);
                setResult(RESULT_OK, intent);
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