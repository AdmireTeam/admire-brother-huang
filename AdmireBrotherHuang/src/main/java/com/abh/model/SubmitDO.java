package com.abh.model;

import java.io.Serializable;


public class SubmitDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cityId;

	private String name;


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
