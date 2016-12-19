package com.example.admin.calendar;

import com.example.admin.calendar.Bean.XZ;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;



public class CreateXZFromWEB extends Thread{

    private String xzName;
    private XZ xz;

    public CreateXZFromWEB(String xzName){
        this.xzName = xzName;
    }

    @Override
    public void run() {
        try {

            Document doc = Jsoup.connect("http://www.go108.com.cn/astro/daily/" + xzName + "#main").get();
            //System.out.println(doc);

            // 解析今日运势
            Element today = doc.getElementsByAttributeValue("class", "xxk_k1_left_wz01").first();
            System.out.println("今日运势解析: " + today.ownText());

            // 幸运数字
            Element luckNum = doc.getElementsByAttributeValue("class", "xxk_k1_left_wz01_a").get(0);
            System.out.println("幸运数字: " + luckNum.ownText().split("：")[1]);

            // 幸运颜色
            Element luckColor = doc.getElementsByAttributeValue("class", "xxk_k1_left_wz01_a").get(1);
            System.out.println("幸运颜色: " + luckColor.ownText().split("：")[1]);

            // 贵人星座
            Element luckXZ = doc.getElementsByAttributeValue("class", "xxk_k1_left_wz01_a").get(2);
            System.out.println("贵人星座: " + luckXZ.ownText().split("：")[1]);

            // 幸运颜色
            Element luckAspect = doc.getElementsByAttributeValue("class", "xxk_k1_left_wz01_a").get(3);
            System.out.println("开运方向: " + luckAspect.ownText().split("：")[1]);

            // 吉时吉色
            Element luckTime = doc.getElementsByAttributeValue("class", "xxk_k1_left_wz01_b").get(0);
            System.out.println("吉时吉色: " + luckTime.ownText().split("：")[1]);

            xz = new XZ();
            xz.setYunshi(today.ownText());
            xz.setLuckNum(luckNum.ownText().split("：")[1]);
            xz.setLuckColor(luckColor.ownText().split("：")[1]);
            xz.setLuckXZ(luckXZ.ownText().split("：")[1]);
            xz.setLuckAspect(luckAspect.ownText().split("：")[1]);
            xz.setLuckTime(luckTime.ownText().split("：")[1]);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public XZ getXz() {
        return xz;
    }
}
