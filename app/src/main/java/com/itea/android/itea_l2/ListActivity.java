package com.itea.android.itea_l2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lvListContacts;
    private LVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //POJO p = getIntent().getExtras().getParcelable();
        lvListContacts = (ListView) findViewById(R.id.lvListContacts);
        adapter = new LVAdapter(this, R.layout.each_item_list);
        lvListContacts.setAdapter(adapter);
        List<POJO> l = new ArrayList<POJO>();
        //l.add(new POJO());
        //l.add(new ImageView(getApplicationContext()));
        adapter.updateList(l);
    }
}
