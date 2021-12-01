package com.program.order.model;

import org.springframework.stereotype.Component;

@Component
public class BestProposal1 {

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Promotion1 getAppliedPromotion() {
		return appliedPromotion;
	}

	public void setAppliedPromotion(Promotion1 appliedPromotion) {
		this.appliedPromotion = appliedPromotion;
	}

	private Double rate = 0.0;
	private Promotion1 appliedPromotion;

}
