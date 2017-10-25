package com.sami.sqlitetest;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id integer primary key autoincrement, name text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into user(name) values('"+name+"');");
        db.close();
    }

    public String getResult(){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("select * from user", null);
        while(cursor.moveToNext()){
            result += cursor.getString(0)+", "+cursor.getString(1)+"\n";
        }
        return result;
    }
}
