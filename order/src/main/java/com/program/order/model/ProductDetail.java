package com.program.order.model;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.stereotype.Component;
@Component
public class ProductDetail {
	
	public ProductDetail() {
		super();
		Product product1 = new Product();
		Product product2= new Product();
		Product product3= new Product();
		Product product4= new Product();
		
		product1.setId(1);
		product1.setName("A");
		product1.setRate(50);
		
		product2.setId(2);
		product2.setName("B");
		product2.setRate(30);
		
		product3.setId(3);
		product3.setName("C");
		product3.setRate(20);
		
		product4.setId(4);
		product4.setName("D");
		product4.setRate(15);
		
		productsDetail.put(product1.getName(), product1);
		productsDetail.put(product2.getName(), product2);
		productsDetail.put(product3.getName(), product3);
		productsDetail.put(product4.getName(), product4);
	}

	private HashMap<String , Product> productsDetail = new HashMap();

	public HashMap<String, Product> getProductsDetail() {
		return productsDetail;
	}

	public void setProductsDetail(HashMap<String, Product> productsDetail) {
		this.productsDetail = productsDetail;
	}

}
