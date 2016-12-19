package com.example.admin.calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.admin.calendar.Bean.Note;

import java.util.ArrayList;



public class NoteDB {

    private static final String TAG = "myTag";

    private static NoteDBHelper noteDBHelper;
    private Context context;

    public NoteDB(Context context){
        if(noteDBHelper == null){
            noteDBHelper = new NoteDBHelper(context);
        }
    }

    // 得到单个Note
    public Note getNote(String id){

        SQLiteDatabase sqLiteDatabase = noteDBHelper.getReadableDatabase();

        String sql = "select * from notes where _ID=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{id});
        if(cursor.moveToNext()){
            Note note = new Note();
            note.setId(id);
            note.setDate(cursor.getString(cursor.getColumnIndex(NoteDBHelper.DATE)));
            note.setTitle(cursor.getString(cursor.getColumnIndex(NoteDBHelper.TITLE)));
            note.setContent(cursor.getString(cursor.getColumnIndex(NoteDBHelper.CONTENT)));
            return note;
        }
        return null;
    }

    // 根据日期得到该日的全部note
    public ArrayList<Note> getAllNotes(String date){

        SQLiteDatabase sqLiteDatabase = null;
        Log.i(TAG, "getAllNotes: " + date);
        if(noteDBHelper != null){
            sqLiteDatabase = noteDBHelper.getReadableDatabase();
        }
        String sql = "select * from notes where date=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{date});
        Log.i(TAG, "getAllNotes: " + cursor.getCount());

        return cursorToNoteList(cursor);
    }

    public ArrayList<Note> cursorToNoteList(Cursor cursor){

        ArrayList<Note> result = new ArrayList<>();

        while (cursor.moveToNext()) {
            Note note = new Note();
            note.setId(cursor.getString(cursor.getColumnIndex(NoteDBHelper.ID)));
            note.setDate(cursor.getString(cursor.getColumnIndex(NoteDBHelper.DATE)));
            note.setTitle(cursor.getString(cursor.getColumnIndex(NoteDBHelper.TITLE)));
            note.setContent(cursor.getString(cursor.getColumnIndex(NoteDBHelper.CONTENT)));
            result.add(note);
        }

        return result;
    }

    // 插入note
    public void insert(ContentValues values) {

        SQLiteDatabase db = noteDBHelper.getWritableDatabase();

        // 插入成功，返回ID
        // 插入失败返回-1
        long newRowId = db.insert(
                NoteDBHelper.TABLE_NAME,  //表名
                null,   // 空列的默认值
                values);    // ContentValues封装好的键值对
    }

    // 删除note
    public void delete(String id) {

        SQLiteDatabase sqLiteDatabase = noteDBHelper.getReadableDatabase();

        String sql = "delete from notes where _id='" + id + "'";

        sqLiteDatabase.execSQL(sql);
    }

    // 更新note
    public void update(String content, String id){

        SQLiteDatabase sqLiteDatabase = noteDBHelper.getWritableDatabase();

        String sql = "update notes set content=? where _id=?";

        sqLiteDatabase.execSQL(sql, new String[]{content, id});
    }

}
