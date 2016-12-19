package com.example.admin.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.calendar.Bean.HL;

public class HLActivity extends AppCompatActivity {

    private static final String TAG = "myTag";

    private TextView yangL, yinL, suiC, xingX, caiSW, Yi, Ji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hl);

        yangL = (TextView)findViewById(R.id.tv_yangli);
        yinL = (TextView)findViewById(R.id.tv_yinli);
        suiC = (TextView)findViewById(R.id.tv_suici);
        caiSW = (TextView)findViewById(R.id.tv_caishenwei);
        xingX = (TextView)findViewById(R.id.tv_xingxiu);
        Yi = (TextView)findViewById(R.id.tv_yi);
        Ji = (TextView)findViewById(R.id.tv_ji);

        Intent intent = getIntent();
        String currentDate = intent.getStringExtra("currentDate");
        Log.i(TAG, "onCreate: " + currentDate);
        CreateHLFromWEB createHLFromWEB = new CreateHLFromWEB(currentDate);
        try {
            createHLFromWEB.start();
            createHLFromWEB.join();
            HL hl = createHLFromWEB.getHL();
            Log.i(TAG, "onCreate: hl" + hl);
            if(hl != null){
                yangL.setText(hl.getYangli());
                yinL.setText(hl.getYinli());
                suiC.setText(hl.getSuici());
                xingX.setText(hl.getXingxiu());
                caiSW.setText(hl.getCaishenwei());
                Yi.setText(hl.getYi());
                Ji.setText(hl.getJi());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
