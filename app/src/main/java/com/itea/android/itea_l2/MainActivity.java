package com.itea.android.itea_l2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements TestDialogFragment.IChangeActivityState {
    private Button bShowDialog;
    private RelativeLayout activity_main;
    private boolean themeCYAN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bShowDialog = (Button) findViewById(R.id.bShowDialog);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        bShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                TestDialogFragment testDialogFragment = new TestDialogFragment();
//                testDialogFragment.setArguments(null);
                TestDialogFragment.newInstance("Hello from MainActivity").show(ft, "Some_tag");
            }
        });
    }

    @Override
    public void changeActivityBackground() {
        if (themeCYAN){
            activity_main.setBackgroundColor(Color.WHITE);
            themeCYAN = false;
        }
        else {
            activity_main.setBackgroundColor(Color.CYAN);
            themeCYAN = true;
        }
    }
}