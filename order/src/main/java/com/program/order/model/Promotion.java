package com.program.order.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component
public class Promotion {
	
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
	public HashMap<String, Long> getProducts() {
		return products;
	}
	public void setProducts(HashMap<String, Long> products) {
		this.products = products;
	}
	private boolean active ;
	private double rate;
	private HashMap<String , Long> products = new HashMap<String , Long>();

}
