package com.itea.android.itea_l2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.tbMyToolbar);
        setSupportActionBar(toolbar);

//        toolbar.setBackground(null);
        toolbar.setTitle("MyTitle");
        toolbar.setNavigationIcon(android.R.drawable.sym_def_app_icon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Item 1").setIcon(R.drawable.contact_icon).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }
}