package com.usecase.mortgage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access=Access.WRITE_ONLY)
	private Long id;
	private double loanAmount;
	private float interestPercentage;
	private int period;
	private double emi;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public float getInterestPercentage() {
		return interestPercentage;
	}
	public void setInterestPercentage(float interestPercentage) {
		this.interestPercentage = interestPercentage;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}

}
