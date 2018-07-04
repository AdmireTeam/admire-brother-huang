package com.abh.model;

import java.io.Serializable;

/**
 * Created by zqc on 2018/7/4.
 */
public class TestDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer foo;
    private String bar;

    public Integer getFoo() {
        return foo;
    }

    public void setFoo(Integer foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
