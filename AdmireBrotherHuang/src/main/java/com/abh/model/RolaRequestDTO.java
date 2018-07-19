package com.abh.model;
import java.io.Serializable;

public class RolaRequestDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String conNum;
    private String waterNum;
    private String reading;

    public String getConNum() {
        return conNum;
    }

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }

    public String getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(String waterNum) {
        this.waterNum = waterNum;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }




}
