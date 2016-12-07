package com.itea.android.itea_l2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvListImage;
    private LVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListImage = (ListView) findViewById(R.id.lvListImage);
        adapter = new LVAdapter(this, R.layout.activity_adapter);
        lvListImage.setAdapter(adapter);

        List<ImageView> l = new ArrayList<ImageView>();
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        l.add(new ImageView(getApplicationContext()));
        adapter.updateList(l);

    }
}
