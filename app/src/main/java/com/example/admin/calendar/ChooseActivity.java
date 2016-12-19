package com.example.admin.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class    ChooseActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView[] xzs;
    private int[] xzNames = {R.id.xz_by, R.id.xz_cv, R.id.xz_jn, R.id.xz_jx, R.id.xz_mx, R.id.xz_shz,
            R.id.xz_sp, R.id.xz_ss, R.id.xz_sy, R.id.xz_sz, R.id.xz_tp, R.id.xz_tx};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        xzs = new TextView[12];

        for(int i=0; i<xzs.length; i++){
            xzs[i] = (TextView)findViewById(xzNames[i]);
            xzs[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        String xzName = "";
        switch (v.getId()){
            case R.id.xz_by:
                xzName = "baiyang";
                break;
            case R.id.xz_cv:
                xzName = "chunv";
                break;
            case R.id.xz_jn:
                xzName = "jinniu";
                break;
            case R.id.xz_jx:
                xzName = "juxie";
                break;
            case R.id.xz_mx:
                xzName = "mojie";
                break;
            case R.id.xz_shz:
                xzName = "shizi";
                break;
            case R.id.xz_ss:
                xzName = "sheshou";
                break;
            case R.id.xz_sp:
                xzName = "shuiping";
                break;
            case R.id.xz_sy:
                xzName = "shuangyu";
                break;
            case R.id.xz_sz:
                xzName = "shuangzi";
                break;
            case R.id.xz_tp:
                xzName = "tiancheng";
                break;
            case R.id.xz_tx:
                xzName = "tianxie";
                break;
        }
        Intent intent = new Intent(ChooseActivity.this, XZActivity.class);
        intent.putExtra("xzName", xzName);
        startActivity(intent);
    }
}
