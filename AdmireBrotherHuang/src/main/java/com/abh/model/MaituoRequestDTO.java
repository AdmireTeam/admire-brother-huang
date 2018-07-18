package com.abh.model;
import java.io.Serializable;

public class MaituoRequestDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    public void setConAddress(String conAddress) {
        this.conAddress = conAddress;
    }

    public String getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(String waterNum) {
        this.waterNum = waterNum;
    }

    public String getAccumulate1() {
        return accumulate1;
    }

    public void setAccumulate1(String accumulate1) {
        this.accumulate1 = accumulate1;
    }

    public String getAccumulate2() {
        return accumulate2;
    }

    public void setAccumulate2(String accumulate2) {
        this.accumulate2 = accumulate2;
    }

    public String getInstantFlow() {
        return instantFlow;
    }

    public void setInstantFlow(String instantFlow) {
        this.instantFlow = instantFlow;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String conAddress;
    private String waterNum;
    private String accumulate1;
    private String accumulate2;
    private String instantFlow;
    private String time;


    public String getConAddress() {
        return conAddress;
    }


}
