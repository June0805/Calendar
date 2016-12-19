package com.example.admin.calendar;

import com.example.admin.calendar.Bean.HL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;



public class CreateHLFromWEB extends Thread{

    private String requestDate;
    private HL hl;

    public CreateHLFromWEB(String requestDate){
        this.requestDate = requestDate;
    }

    @Override
    public void run() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.meiguoshenpo.com/huangli/" + requestDate + ".html").get();
            Element content = doc.getElementById("LEFT_DIV");
            Element table = content.getElementsByTag("table").first();
            //System.out.println(table);

            // 解析阳历
            Element eYangL = table.getElementsByAttributeValue("class", "red").get(0);
            System.out.println("阳历: " + eYangL.ownText());  //公元 2016年11月4日 星期五

            // 解析阴历
            Element eYinL = table.getElementsByTag("tr").get(1).getElementsByTag("td").first();
            System.out.println("阴历: " + eYinL.ownText());	//二零一六年 十月初五

            // 解析岁次
            Element eSC = table.getElementsByTag("tr").get(2).getElementsByTag("td").first();
            System.out.println("岁次: " + eSC.ownText());	//丙申年 戊戍月 庚寅日

            // 解析星宿
            Element eXX = table.getElementsByTag("tr").get(7).getElementsByTag("td").first();
            System.out.println("星宿: " + eXX.ownText());	//女宿(女土蝠)

            // 解析财神位
            Element eCSW = table.getElementsByTag("tr").get(8).getElementsByTag("td").first();
            System.out.println("财神位: " + eCSW.ownText());	//喜神西北   福神西南   财神正东

            // 解析宜
            Element eY = table.getElementsByTag("tr").get(17).getElementsByTag("td").first();
            System.out.println("宜: " + eY.ownText());

            // 解析忌
            Element eJ = table.getElementsByTag("tr").get(18).getElementsByTag("td").first();
            System.out.println("忌: " + eJ.ownText());

            hl = new HL();
            hl.setYangli(eYangL.ownText());
            hl.setYinli(eYinL.ownText());
            hl.setSuici(eSC.ownText());
            hl.setXingxiu(eXX.ownText());
            hl.setCaishenwei(eCSW.ownText());
            hl.setYi(eY.ownText());
            hl.setJi(eJ.ownText());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HL getHL(){
        return hl;
    }

}
