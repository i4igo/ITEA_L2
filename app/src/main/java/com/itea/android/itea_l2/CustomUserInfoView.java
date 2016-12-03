package com.itea.android.itea_l2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Ev on 03.12.2016.
 */

public class CustomUserInfoView extends TableRow {
    public ImageView ivPhoto;
    public TextView tvName;
    public TextView tvCountry;
    public RatingBar rbRating;


    public CustomUserInfoView(Context context) {
//        super(context);
        this(context, null);
    }

    public CustomUserInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TableRow trRoot = (TableRow)inflater.inflate(R.layout.custom_view, this, true);

        ivPhoto = (ImageView) trRoot.findViewById(R.id.ivPhoto);
        tvName = (TextView) trRoot.findViewById(R.id.tvName);
        tvName.setText("Петро Петренко");
        tvCountry = (TextView) trRoot.findViewById(R.id.tvCountry);
        tvCountry.setText("Ukraine");
        rbRating = (RatingBar) trRoot.findViewById(R.id.rbRating);
        rbRating.setRating(3.7f);
    }
}
