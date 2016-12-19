package com.example.admin.calendar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.admin.calendar.Bean.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteListActivity extends AppCompatActivity {

    private static final String TAG = "myTag";

    private ListView list;
    private String date;
    private TextView add;
    private NoteDB noteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        noteDB = new NoteDB(this);

        add = (TextView)findViewById(R.id.add);
        date = getIntent().getStringExtra("currentDate");
        list = (ListView)findViewById(R.id.notesList);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteListActivity.this, NoteAddActivity.class);
                intent.putExtra("currentDate", date);
                startActivity(intent);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Note> noteList = noteDB.getAllNotes(date);
                Note note = noteList.get(position);
                detailDialog(note);
            }
        });

    }

    public void detailDialog(final Note note){
        new AlertDialog.Builder(this)
                .setTitle(note.getTitle())//标题
                .setMessage("\n" + note.getContent() + "\n")
                //确定按钮及其动作
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                //取消按钮及其动作
                .setNegativeButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        noteDB.delete(note.getId());
                        refresh();
                    }
                })
                .create()//创建对话框
                .show();//显示对话框
    }

    public void refresh(){

        List<Note> noteList = noteDB.getAllNotes(date);
        List<Map<String, String>> items = new ArrayList<>();
        for (int i=0; i<noteList.size(); i++){
            Map<String, String> item = new HashMap<>();
            item.put("id", noteList.get(i).getId());
            item.put("title", noteList.get(i).getTitle());
            item.put("content", noteList.get(i).getContent());
            items.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, items,
                R.layout.item, new String[]{"id", "title", "content"},
                new int[]{R.id.list_id, R.id.list_title, R.id.list_content});
        list.setAdapter(simpleAdapter);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        refresh();
    }
}
