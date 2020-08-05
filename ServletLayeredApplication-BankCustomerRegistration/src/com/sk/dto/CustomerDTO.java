package com.sk.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
	private String name;
//	private String address;
	private float initAmt;
	private String accType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public float getInitAmt() {
		return initAmt;
	}
	public void setInitAmt(float initAmt) {
		this.initAmt = initAmt;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
}
