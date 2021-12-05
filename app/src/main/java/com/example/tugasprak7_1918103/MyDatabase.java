package com.example.tugasprak7_1918103;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_SepakBola";
    private static final String tb_jadwal = "tb_jadwal";
    private static final String tb_jadwal_id = "id";
    private static final String tb_jadwal_jadwal= "jadwal";
    private static final String tb_jadwal_tim = "tim";
    private static final String CREATE_TABLE_JADWAL = "CREATE TABLE "
            + tb_jadwal +"("
            + tb_jadwal_id + " INTEGER PRIMARY KEY ,"
            + tb_jadwal_jadwal + " TEXT ,"
            + tb_jadwal_tim + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JADWAL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateJadwal(Jadwal data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jadwal_id, data.get_id());
        values.put(tb_jadwal_jadwal, data.get_jadwal());
        values.put(tb_jadwal_tim, data.get_tim());
        db.insert(tb_jadwal, null, values);
        db.close();
    }
    public List<Jadwal> ReadJadwal() {
        List<Jadwal> listJdwl = new ArrayList<Jadwal>();
        String selectQuery = "SELECT * FROM " + tb_jadwal;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Jadwal data = new Jadwal();
                data.set_id(cursor.getString(0));
                data.set_jadwal(cursor.getString(1));
                data.set_tim(cursor.getString(2));
                listJdwl.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listJdwl;
    }
    public int UpdateJadwal (Jadwal data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_jadwal, data.get_jadwal());
        values.put(tb_jadwal_tim, data.get_tim());
        return db.update(tb_jadwal, values, tb_jadwal_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteJadwal(Jadwal data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_jadwal,tb_jadwal_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}