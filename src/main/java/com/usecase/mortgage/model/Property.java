package com.usecase.mortgage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String propertyName;
	private String type;
	private double area;
	private Long pincode;
	private String address;

	public Property() {

	}	

	public Property(String propertyName, String type, double area, Long pincode, String address) {
		super();
		this.propertyName = propertyName;
		this.type = type;
		this.area = area;
		this.pincode = pincode;
		this.address = address;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
