package com.abh.model;
import java.io.Serializable;

public class MaituoRequestDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String conAddress;
    private String waterNum;
    private String accumulate1;
    private String accumulate2;
    private String instantFlow;
    private String time;


    public String getConAddress() {
        return conAddress;
    }

    public void setNumber(String conAddress) {
        this.conAddress = conAddress;
    }

    public String getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(String water) { water = waterNum; }

    public String getAccumulate1() {
        return accumulate1;
    }

    public void setAccu1(String accu1) {
        accu1 = accumulate1;
    }

    public String getAccumulate2() {
        return accumulate2;
    }

    public void setAccu2(String accu2) {
        accu2 = accumulate2;
    }

    public String getInstant() { return instantFlow; }

    public void setInstant(String instant) {
        instant = instantFlow;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time1) {
        time1 = time;
    }

}
