package com.itea.android.itea_l2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

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
        list = new ArrayList<>();
        this.context = context;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public List<POJO> getList(){
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
        if (view == null){
            view = inflater.inflate(R.layout.each_item_list, parent, false);
        }
        ImageView ivListItem = (ImageView) view.findViewById(R.id.ivListItem);

        Picasso.with(getContext())
                .load("http://a1.mzstatic.com/us/r30/Purple3/v4/ed/dd/e3/eddde34d-892d-a1f7-b60c-1a515dad042d/icon256x256.jpeg")
                .resize(64, 64)
                .into(ivListItem);
        return view;
    }


    public void updateList(List<POJO> l) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
        Toast.makeText(getContext(), "updateList", Toast.LENGTH_SHORT).show();
    }
}