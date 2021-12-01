package com.program.order.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ActivePromotion {
	
	public ActivePromotion() {
		super();
		Promotion promotion1 = new Promotion();
		Promotion promotion2 = new Promotion();
		Promotion promotion3 = new Promotion();
		
		promotion1.setActive(true);
		promotion1.setRate(130);
		HashMap<String , Long > prodMap1 = promotion1.getProducts();
		prodMap1.put("A", (long) 3);
		
		promotion2.setActive(true);
		promotion2.setRate(130);
		HashMap<String , Long > prodMap2 = promotion2.getProducts();
		prodMap2.put("B", (long) 2);
		
		promotion3.setActive(true);
		promotion3.setRate(130);
		HashMap<String , Long > prodMap3 = promotion3.getProducts();
		prodMap3.put("B", (long) 1);
		prodMap3.put("C", (long) 1);
		
		promotions.add(promotion1);
		promotions.add(promotion2);
		promotions.add(promotion3);
		
		
	}

	public Set<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}

	private Set<Promotion> promotions = new HashSet();

}
