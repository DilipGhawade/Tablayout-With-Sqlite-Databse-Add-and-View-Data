package com.meteorsoftech.slidingtablayoutsqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Delete on 9/16/2017.
 */

public class MySQliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="register.DB";
    private static final int DATABASE_VERSION=1;
    protected static final String CREATE_QUERY=
            "CREATE TABLE "+ DataModel.Usercontrac.TABLE_NAME+"" +
                    "("+ DataModel.Usercontrac.USER_NAME+" TEXT,"+
                    DataModel.Usercontrac.USER_MOB+" TEXT,"+
                    DataModel.Usercontrac.USER_EMAIL+" TEXT);";

    public MySQliteHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("Database Operation","Database is created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("Database Operation","Table is Created");

    }
    public void addInformation(String name,String mobileno,String email,SQLiteDatabase db)
    {
        ContentValues values = new ContentValues();
        values.put(DataModel.Usercontrac.USER_NAME,name);
        values.put(DataModel.Usercontrac.USER_MOB,mobileno);
        values.put(DataModel.Usercontrac.USER_EMAIL,email);
        db.insert(DataModel.Usercontrac.TABLE_NAME,null,values);

    }
    public Cursor getinformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projection={DataModel.Usercontrac.USER_NAME,
                DataModel.Usercontrac.USER_MOB,
                DataModel.Usercontrac.USER_EMAIL};
        cursor = db.query(DataModel.Usercontrac.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
