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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lvListContacts;
    private LVAdapter adapter;
    private List<POJO> l;

    private Button bBack;
    private Button bClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (getIntent().getExtras() != null) {

            POJO p1 = getIntent().getExtras().getParcelable(Constants.KEY);

            lvListContacts = (ListView) findViewById(R.id.lvListContacts);
            adapter = new LVAdapter(this, R.layout.each_item_list);
            lvListContacts.setAdapter(adapter);

            l = new ArrayList<POJO>();
            l.add(p1);

            adapter.updateList(l);

            lvListContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder adBuilder = new AlertDialog.Builder(ListActivity.this);

                    adBuilder.setCancelable(false);
                    adBuilder.setTitle("Внимание");
                    adBuilder.setMessage("Вы действительно хотите удалить контакт?");

                    adBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    l.remove(position);
                                }
                            });

                    adBuilder.show();

                    return false;
                }
            });
        }


/*

        // вернуться назад
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // закрыть
        bClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/

    }
}

    /*Toast.makeText(PersonActivity.this, "у вас есть заполненные поля", Toast.LENGTH_SHORT).show();
      если список пуст, вывести сообщение "список еще пуст"
    */