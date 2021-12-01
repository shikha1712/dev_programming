package com.program.order.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component
public class Promotion1 {
	
	public ArrayList<String> getProductDetailsList() {
		return productDetailsList;
	}
	public void setProductDetailsList(ArrayList<String> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}

	private boolean active ;
	private double rate;
	private ArrayList<String> productDetailsList = new ArrayList<String>();

}
