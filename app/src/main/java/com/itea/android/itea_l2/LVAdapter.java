package com.itea.android.itea_l2;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ev on 06.12.2016.
 */

public class LVAdapter extends ArrayAdapter<POJO> {
    private List<POJO> list;
    private Context context;
    private LayoutInflater inflater;

    public LVAdapter(Context context, int resource) {
        super(context, resource);
        this.list = new ArrayList<>();
        this.context = context;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public List<POJO> getList() {
        return list;
    }

    @Nullable
    @Override
    public POJO getItem(int position) {
        return list.get(position);
    }

    /* сколько будет отображаться*/
    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.each_item_list, parent, false);
        }

        ImageView tImage = (ImageView) view.findViewById(R.id.ivIcon);
        TextView tFullName = (TextView) view.findViewById(R.id.tName);
        //TextView tLName = (TextView) view.findViewById(R.id.tLName);
        TextView tPNumber = (TextView) view.findViewById(R.id.tPNumber);
        //TextView tCountry = (TextView) view.findViewById(R.id.tCountry);
        //TextView tCity = (TextView) view.findViewById(R.id.tCity);
        TextView tAdress = (TextView) view.findViewById(R.id.tCountry);
        TextView tEmail = (TextView) view.findViewById(R.id.tEmail);
        TextView tNotes = (TextView) view.findViewById(R.id.tNotes);

        //Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), list.get(position).getIvImage());
        //tImage.setImageURI(Uri.parse(list.get(position).getIvImage()));
        tFullName.setText(list.get(position).getEtName() + " " + list.get(position).getEtLName());
        //tLName.setText(list.get(position).getEtLName());
        tPNumber.setText(list.get(position).getEtPNumber());
        tAdress.setText(list.get(position).getEtCountry() + ", " + list.get(position).getEtCity());
        //tCountry.setText(list.get(position).getEtCountry());
        //tCity.setText(list.get(position).getEtCity());
        tEmail.setText(list.get(position).getEtEmail());


        Picasso.with(getContext())
                //.load("http://a1.mzstatic.com/us/r30/Purple3/v4/ed/dd/e3/eddde34d-892d-a1f7-b60c-1a515dad042d/icon256x256.jpeg")
                .load(Uri.parse(list.get(position).getIvImage()))
                .resize(60, 60)
                .into(tImage);
        return view;
    }

    public void updateList(List<POJO> l) {
        this.list.clear();
        this.list.addAll(l);
        notifyDataSetChanged();
        //Toast.makeText(getContext(), "updateList", Toast.LENGTH_SHORT).show();
    }
}