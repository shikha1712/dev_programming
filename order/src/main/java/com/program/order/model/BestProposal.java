package com.program.order.model;

import org.springframework.stereotype.Component;

@Component
public class BestProposal {

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Promotion getAppliedPromotion() {
		return appliedPromotion;
	}

	public void setAppliedPromotion(Promotion appliedPromotion) {
		this.appliedPromotion = appliedPromotion;
	}

	private Double rate = 0.0;
	private Promotion appliedPromotion;

}
