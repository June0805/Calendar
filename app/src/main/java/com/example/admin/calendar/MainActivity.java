package com.example.admin.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "myTag";

    private String currentDate;
    private CalendarView calendarView;
    private TextView textView;
    private Button hlButton, xzButton, rcButton;
    private TextPaint tp;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hlButton = (Button)findViewById(R.id.btn_hl);
        xzButton = (Button)findViewById(R.id.btn_xz);
        rcButton = (Button)findViewById(R.id.btn_rc);
        calendarView = (CalendarView)findViewById(R.id.cal);
        textView = (TextView)findViewById(R.id.tv_title);
        tp = textView.getPaint();
        tp.setFakeBoldText(true);

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(calendarView.getDate());
        String year = c.get(Calendar.YEAR) + "";
        String month = (c.get(Calendar.MONTH) + 1) + "";
        String day = c.get(Calendar.DAY_OF_MONTH) + "";
        currentDate = year + "-" + month + "-" + day;
        Log.i(TAG, "onCreate: " + currentDate);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                currentDate = year + "-" + (month+1) + "-" + dayOfMonth;
                Log.i(TAG, "onSelectedDayChange: " + currentDate);
            }
        });

        hlButton.setOnClickListener(this);
        xzButton.setOnClickListener(this);
        rcButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_hl:
                intent = new Intent(MainActivity.this, HLActivity.class);
                intent.putExtra("currentDate", currentDate);
                startActivity(intent);
                break;
            case R.id.btn_xz:
                intent = new Intent(MainActivity.this, ChooseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_rc:
                intent = new Intent(MainActivity.this, NoteListActivity.class);
                intent.putExtra("currentDate", currentDate);
                startActivity(intent);
                break;
        }
    }
}

