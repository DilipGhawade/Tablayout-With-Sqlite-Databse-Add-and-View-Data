package com.meteorsoftech.slidingtablayoutsqlitedemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Delete on 9/16/2017.
 */

public class Fragment_Add extends Fragment {
    EditText edtname,edtmob,edtemail;
   // Context context=this;
    MySQliteHelper mysqlDbHelper;
    SQLiteDatabase sqLiteDatabase;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtname = (EditText)view.findViewById(R.id.edt_username);
        edtemail = (EditText)view.findViewById(R.id.edt_useremail);
        edtmob  = (EditText)view.findViewById(R.id.edt_userphone);
        button = (Button)view.findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    public void register()
    {
        String name=edtname.getText().toString();
        String mob=edtmob.getText().toString();
        String emaill=edtemail.getText().toString();

        mysqlDbHelper = new MySQliteHelper(getContext());
        sqLiteDatabase=mysqlDbHelper.getWritableDatabase();
        mysqlDbHelper.addInformation(name,mob,emaill,sqLiteDatabase);
        Toast.makeText(getContext(),"Register Successfully",Toast.LENGTH_LONG).show();
        mysqlDbHelper.close();
    }
}
