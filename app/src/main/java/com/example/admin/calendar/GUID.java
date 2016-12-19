package com.example.admin.calendar;

import android.util.Log;

import java.util.UUID;



public class GUID {

    public static String getGUID(){
        // 创建 UUID 对象
        // 产生唯一的标识码
        UUID uuid = UUID.randomUUID();
        // 得到对象产生的ID
        String a = uuid.toString();

        a = a.replaceAll("-", "");

        return a;
    }

}
