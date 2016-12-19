package com.example.admin.calendar.Bean;



public class HL {

    private String yangli;	//阳历
    private String yinli;	//阴历
    private String suici;	//岁次
    private String xingxiu;	//星宿
    private String caishenwei;	//财神位
    private String yi;	//宜
    private String ji;	//忌

    public HL() {

    }

    public String getYangli() {
        return yangli;
    }
    public void setYangli(String yangli) {
        this.yangli = yangli;
    }
    public String getYinli() {
        return yinli;
    }
    public void setYinli(String yinli) {
        this.yinli = yinli;
    }
    public String getSuici() {
        return suici;
    }
    public void setSuici(String suici) {
        this.suici = suici;
    }
    public String getXingxiu() {
        return xingxiu;
    }
    public void setXingxiu(String xingxiu) {
        this.xingxiu = xingxiu;
    }
    public String getCaishenwei() {
        return caishenwei;
    }
    public void setCaishenwei(String caishenwei) {
        this.caishenwei = caishenwei;
    }
    public String getYi() {
        return yi;
    }
    public void setYi(String yi) {
        this.yi = yi;
    }
    public String getJi() {
        return ji;
    }
    public void setJi(String ji) {
        this.ji = ji;
    }

    @Override
    public String toString() {
        return "HL [yangli=" + yangli + ", yinli=" + yinli + ", suici=" + suici + ", xingxiu=" + xingxiu
                + ", caishenwei=" + caishenwei + ", yi=" + yi + ", ji=" + ji + "]";
    }

}
