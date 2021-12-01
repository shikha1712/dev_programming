package com.program.order.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component
public class UserCartDetail {
	
	public HashMap<String, Long> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(HashMap<String, Long> productDetails) {
		this.productDetails = productDetails;
	}

	private HashMap<String , Long> productDetails = new HashMap<String , Long>();
	

}
