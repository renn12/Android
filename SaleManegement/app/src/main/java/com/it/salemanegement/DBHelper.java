package com.it.salemanegement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.it.salemanegement.vo.MemberVO;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id text primary key, password text not null, name text not null, phone text);");
        db.execSQL("create table product(pid integer primary key autoincrement, code text not null, name text not null, price integer not null);");
        db.execSQL("create table finance(fid integer primary key autoincrement, " +
                "id text not null, pid text not null, foreign key (id) " +
                "references user(id) on delete cascade, foreign key(pid) references product(pid) on delete cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void join(MemberVO mem){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into user values(?, ?, ?, ?)";
        String[] params = {mem.getId(), mem.getPassword(), mem.getName(), mem.getPhone()};
        //db.execSQL("INSERT INTO user VALUES( '" + memberVO.getId() + "', '"+ memberVO.getPassword() + "','"+memberVO.getName()+"', '"+memberVO.getPhone()+"');");

        db.execSQL(sql, params);
        db.close();
    }

    public int exist(MemberVO memberVO){
        int result = 0;
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select count(*) from user where id=?";
        Cursor cursor = db.rawQuery(sql, new String[] {memberVO.getId()});
        if(cursor.moveToNext()) result = cursor.getInt(0);
        cursor.close();
        db.close();
        return result;
    }


}
