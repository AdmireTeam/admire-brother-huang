package com.abh.model;

import java.io.Serializable;

/**
 * Created by zqc on 2018/7/4.
 */
public class HedaRequestDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String number;
    private String K4;
    private String K5;
    private String A1;
    private String A2;
    private String A3;
    private String A12;
    private String A13;
    private String P13;
    private String P14;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getK4() {
        return K4;
    }

    public void setK4(String k4) {
        K4 = k4;
    }

    public String getK5() {
        return K5;
    }

    public void setK5(String k5) {
        K5 = k5;
    }

    public String getA1() {
        return A1;
    }

    public void setA1(String a1) {
        A1 = a1;
    }

    public String getA2() {
        return A2;
    }

    public void setA2(String a2) {
        A2 = a2;
    }

    public String getA3() {
        return A3;
    }

    public void setA3(String a3) {
        A3 = a3;
    }

    public String getA12() {
        return A12;
    }

    public void setA12(String a12) {
        A12 = a12;
    }

    public String getA13() {
        return A13;
    }

    public void setA13(String a13) {
        A13 = a13;
    }

    public String getP13() {
        return P13;
    }

    public void setP13(String p13) {
        P13 = p13;
    }

    public String getP14() {
        return P14;
    }

    public void setP14(String p14) {
        P14 = p14;
    }
}
