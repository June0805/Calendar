package com.example.admin.calendar;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoteAddActivity extends AppCompatActivity {

    private static final String TAG = "myTag";

    private TextView date;
    private EditText edTitle, edContent;
    private Button ok, cancel;

    private NoteDB noteDB;
    private String currentDate, title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        date = (TextView)findViewById(R.id.add_date);
        edTitle = (EditText)findViewById(R.id.add_title);
        edContent = (EditText)findViewById(R.id.add_content);
        ok = (Button)findViewById(R.id.add_save);
        cancel = (Button)findViewById(R.id.add_cancel);

        noteDB = new NoteDB(this);

        currentDate = getIntent().getStringExtra("currentDate");

        date.setText(currentDate);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = edTitle.getText().toString();
                content = edContent.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put(NoteDBHelper.ID, GUID.getGUID());
                cv.put(NoteDBHelper.DATE, currentDate);
                cv.put(NoteDBHelper.TITLE, title);
                cv.put(NoteDBHelper.CONTENT, content);
                Log.i(TAG, "onClick: " + cv.toString());
                noteDB.insert(cv);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
