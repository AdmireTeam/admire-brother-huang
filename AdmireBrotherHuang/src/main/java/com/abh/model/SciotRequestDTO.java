package com.abh.model;

import java.io.Serializable;

public class SciotRequestDTO implements Serializable {


    private static final long serialVersionUID = 1L;
    private String startDate;
    private String waterNum;
    private String reading;


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

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate;  }

}