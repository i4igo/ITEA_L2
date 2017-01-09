package com.itea.android.itea_l2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        if (pojoList != null) {
            lvListContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AlertDialog.Builder adBuilder = new AlertDialog.Builder(ListActivity.this);
                    adBuilder.setCancelable(false);
                    adBuilder.setTitle(pojoList.get(position).getEtName());
                    //adBuilder.setMessage("re-re");

                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View viewContact = inflater.inflate(R.layout.each_item_dialog, null);

                        ImageView tImage = (ImageView) viewContact.findViewById(R.id.ivIcon);
                        TextView tName = (TextView) viewContact.findViewById(R.id.tName);
                        TextView tLName = (TextView) viewContact.findViewById(R.id.tLName);
                        TextView tPNumber = (TextView) viewContact.findViewById(R.id.tPNumber);
                        TextView tCountry = (TextView) viewContact.findViewById(R.id.tCountry);
                        TextView tCity = (TextView) viewContact.findViewById(R.id.tCity);
                        TextView tEmail = (TextView) viewContact.findViewById(R.id.tEmail);
                        TextView tNotes = (TextView) viewContact.findViewById(R.id.tNotes);

                        //tImage.setImageURI(Uri.parse(pojoList.get(position).getIvImage()));

                    Picasso.with(viewContact.getContext())
                            //.load("http://a1.mzstatic.com/us/r30/Purple3/v4/ed/dd/e3/eddde34d-892d-a1f7-b60c-1a515dad042d/icon256x256.jpeg")
                            .load(Uri.parse(pojoList.get(position).getIvImage()))
                            .resize(100, 100)
                            .into(tImage);

                        tName.setText(pojoList.get(position).getEtName());
                        tLName.setText(pojoList.get(position).getEtLName());
                        tPNumber.setText(pojoList.get(position).getEtPNumber());
                        tCountry.setText(pojoList.get(position).getEtCountry());
                        tCity.setText(pojoList.get(position).getEtCity());
                        tEmail.setText(pojoList.get(position).getEtEmail());
                        tNotes.setText(pojoList.get(position).getEtNotes());

                    adBuilder.setView(viewContact);

                    adBuilder.setPositiveButton(Constants.BUTTON_OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    adBuilder.show();
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