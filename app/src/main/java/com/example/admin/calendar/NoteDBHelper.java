package com.example.admin.calendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class NoteDBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "notes";
    public static final String ID = "_id";
    public static final String DATE = "date";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";

    private static final String CREATE_TABLE_SQL ="CREATE TABLE " + TABLE_NAME + " (" + ID
            + " VARCHAR(32) PRIMARY KEY," + DATE + " TEXT ," + TITLE + " TEXT," + CONTENT
            + " TEXT)";


    public NoteDBHelper(Context context) {
        super(context, "notes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
