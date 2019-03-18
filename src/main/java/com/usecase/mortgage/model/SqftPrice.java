package com.usecase.mortgage.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SqftPrice {
	
	@Id
	private Long pincode;
	private double value;
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	

}
