package com.example.edu.viewholderrecyclerview1109;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "order.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 1;

    public MyDBOpenHelper(Context context) {
        super(context, name, factory, version);
    }

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE [ORDERED]\n" +
                "(\n" +
                "\t[ITEM_COUNT] integer,\n" +
                "\t[ITEM_DATE] text,\n" +
                "\t[ID] integer NOT NULL UNIQUE,\n" +
                "\tPRIMARY KEY ([ID])\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ORDERED ;");
        onCreate(db);
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String ITEM_COUNT) {
        mdb.execSQL("DELETE FROM ORDERED WHERE ITEM_COUNT='" + ITEM_COUNT + "';");
    }

}
