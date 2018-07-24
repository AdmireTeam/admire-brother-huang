package com.abh.model;
import java.io.Serializable;

public class JxRequestDTO {
    private static final long serialVersionUID = 1L;
    private String conAddr;
    private int conCount;
    private int meterCount;

    public String getConAddr() {
        return conAddr;
    }

    public void setConAddr(String conAddr) {
        this.conAddr = conAddr;
    }

    public int getConCount() {
        return conCount;
    }

    public void setConCount(int conCount) {
        this.conCount = conCount;
    }

    public int getMeterCount() {
        return meterCount;
    }

    public void setMeterCount(int meterCount) {
        this.meterCount = meterCount;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    private String reading;





}
