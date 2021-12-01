package com.program.order.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private long id;
	private String name;
	private double rate;
	

}
