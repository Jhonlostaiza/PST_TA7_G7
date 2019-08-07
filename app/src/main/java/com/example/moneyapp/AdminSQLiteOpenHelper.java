package com.example.moneyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ingresos(codigo int primary key, fecha text, ingreso double)");

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int NewVersion) {

    }
}
