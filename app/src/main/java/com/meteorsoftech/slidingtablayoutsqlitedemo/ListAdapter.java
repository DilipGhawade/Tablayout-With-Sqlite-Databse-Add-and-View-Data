package com.meteorsoftech.slidingtablayoutsqlitedemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Delete on 6/24/2017.
 */

public class ListAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public class LayoutHandler
    {
        TextView name,mob,email,address;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() { return list.size();}

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View row=convertView;
        LayoutHandler layoutHandler;
        if (row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.card_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.name=(TextView)row.findViewById(R.id.txt_name);
            layoutHandler.mob=(TextView)row.findViewById(R.id.txt_mobile);
            layoutHandler.email=(TextView)row.findViewById(R.id.txt_email);
            layoutHandler.address=(TextView)row.findViewById(R.id.txt_address);
            row.setTag(layoutHandler);

        }
        else
        {
            layoutHandler =(LayoutHandler) row.getTag();
        }

        Setters dataprovider=(Setters)this.getItem(position);
        layoutHandler.name.setText(dataprovider.getName());
        layoutHandler.mob.setText(dataprovider.getMob());
        layoutHandler.email.setText(dataprovider.getEmail());
        return row;
    }
}
