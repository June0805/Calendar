package com.example.admin.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.calendar.Bean.HL;
import com.example.admin.calendar.Bean.XZ;

public class XZActivity extends AppCompatActivity {

    private static final String TAG = "myTag";

    private ImageView image;
    private TextView yunshi, luckNum, luckColor, luckXZ, luckAspect, luckTime, xzTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xz);

        yunshi = (TextView)findViewById(R.id.tv_yunshi);
        luckNum = (TextView)findViewById(R.id.tv_luckNum);
        luckColor = (TextView)findViewById(R.id.tv_luckColor);
        luckXZ = (TextView)findViewById(R.id.tv_luckXZ);
        luckAspect = (TextView)findViewById(R.id.tv_luckAspect);
        luckTime = (TextView)findViewById(R.id.tv_luckTime);
        image = (ImageView)findViewById(R.id.image);
        xzTitle = (TextView)findViewById(R.id.xz_title);

        Intent intent = getIntent();
        String xzName = intent.getStringExtra("xzName");
        CreateXZFromWEB createXZFromWEB = new CreateXZFromWEB(xzName);
        try {
            createXZFromWEB.start();
            createXZFromWEB.join();
            XZ xz = createXZFromWEB.getXz();
            if(xz != null){
                Log.i(TAG, "onCreate: " + xz);
                yunshi.setText(xz.getYunshi());
                luckNum.setText(xz.getLuckNum());
                luckColor.setText(xz.getLuckColor());
                luckAspect.setText(xz.getLuckAspect());
                luckXZ.setText(xz.getLuckXZ());
                luckTime.setText(xz.getLuckTime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (xzName){
            case "baiyang":
                xzTitle.setText("白羊座");
                image.setImageResource(R.drawable.baiyang);
                break;
            case "chunv":
                xzTitle.setText("处女座");
                image.setImageResource(R.drawable.chunv);
                break;
            case "jinniu":
                xzTitle.setText("金牛座");
                image.setImageResource(R.drawable.jinniu);
                break;
            case "juxie":
                xzTitle.setText("巨蟹座");
                image.setImageResource(R.drawable.juxie);
                break;
            case "mojie":
                xzTitle.setText("摩羯座");
                image.setImageResource(R.drawable.mojie);
                break;
            case "shizi":
                xzTitle.setText("狮子座");
                image.setImageResource(R.drawable.shizi);
                break;
            case "sheshou":
                xzTitle.setText("射手座");
                image.setImageResource(R.drawable.sheshou);
                break;
            case "shuiping":
                xzTitle.setText("水瓶座");
                image.setImageResource(R.drawable.shuiping);
                break;
            case "shuangyu":
                xzTitle.setText("双鱼座");
                image.setImageResource(R.drawable.shuangyu);
                break;
            case "shuangzi":
                xzTitle.setText("双子座");
                image.setImageResource(R.drawable.shuangzi);
                break;
            case "tiancheng":
                xzTitle.setText("天秤座");
                image.setImageResource(R.drawable.tiancheng);
                break;
            case "tianxie":
                xzTitle.setText("天蝎座");
                image.setImageResource(R.drawable.tianxie);
                break;
        }

    }
}
