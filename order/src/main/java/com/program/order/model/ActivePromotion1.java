package com.program.order.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ActivePromotion1 {

	public ActivePromotion1() {
		super();
		Promotion1 promotion1 = new Promotion1();
		Promotion1 promotion2 = new Promotion1();
		Promotion1 promotion3 = new Promotion1();

		promotion1.setActive(true);
		promotion1.setRate(130);
		ArrayList<String> prodMap1 = promotion1.getProductDetailsList();
		prodMap1.add("A");
		prodMap1.add("A");
		prodMap1.add("A");

		promotion2.setActive(true);
		promotion2.setRate(45);
		ArrayList<String> prodMap2 = promotion2.getProductDetailsList();
		prodMap2.add("B");
		prodMap2.add("B");

		promotion3.setActive(true);
		promotion3.setRate(30);
		ArrayList<String> prodMap3 = promotion3.getProductDetailsList();
		prodMap3.add("C");
		prodMap3.add("D");

		promotions.add(promotion1);
		promotions.add(promotion2);
		promotions.add(promotion3);

	}

	public Set<Promotion1> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<Promotion1> promotions) {
		this.promotions = promotions;
	}

	private Set<Promotion1> promotions = new HashSet();

}
