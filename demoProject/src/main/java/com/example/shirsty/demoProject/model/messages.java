package com.example.shirsty.demoProject.model;

import javax.persistence.Entity;

import lombok.Data;


@Data
public class messages extends BaseEntity{
	
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}