package com.abh.model;
import java.io.Serializable;

public class XtRequestDTO {
    private static final long serialVersionUID = 1L;

    private String conStartAddr;
    private int conCount;

    public String getConStartAddr() {
        return conStartAddr;
    }

    public void setConStartAddr(String conStartAddr) {
        this.conStartAddr = conStartAddr;
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

    public String getMeterStartAddr() {
        return meterStartAddr;
    }

    public void setMeterStartAddr(String meterStartAddr) {
        this.meterStartAddr = meterStartAddr;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    private int meterCount;
    private String meterStartAddr;
    private String reading;



}
