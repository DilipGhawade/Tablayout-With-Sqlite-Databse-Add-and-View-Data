package com.meteorsoftech.slidingtablayoutsqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Delete on 9/16/2017.
 */

public class Fragment_Dataview extends Fragment {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    MySQliteHelper mysqlDbHelper;
    Cursor cursor;
    ListAdapter listAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_view,container,false);


        listView = (ListView)v.findViewById(R.id.recyclerview);
        listAdapter = new ListAdapter(getContext(),R.layout.card_layout);
        listView.setAdapter(listAdapter);
        mysqlDbHelper = new MySQliteHelper(getContext());
        sqLiteDatabase = mysqlDbHelper.getReadableDatabase();
        cursor= mysqlDbHelper.getinformation(sqLiteDatabase);

        if (cursor.moveToFirst())
        {
            do {
                String name,mob,email,addresss;
                name=cursor.getString(0);
                mob= cursor.getString(1);
                email=cursor.getString(2);
                Setters dataprovider= new Setters(name,mob,email);
                listAdapter.add(dataprovider);

            }while (cursor.moveToNext());
        }
        return v;
    }

}
