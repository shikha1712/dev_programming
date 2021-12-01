package com.program.order.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class UserCartDetail1 {

	public ArrayList<String> getProductDetailsList() {
		return productDetailsList;
	}

	public void setProductDetailsList(ArrayList<String> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}

	private ArrayList<String> productDetailsList = new ArrayList<String>();

}
