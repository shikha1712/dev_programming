package com.program.order.model;

import org.springframework.stereotype.Component;

@Component
public class PromtionApplicableDetail1 {

	public boolean isPromotionApplied() {
		return promotionApplied;
	}
	public void setPromotionApplied(boolean promotionApplied) {
		this.promotionApplied = promotionApplied;
	}
	public BestProposal1 getPromotiondetail() {
		return promotiondetail;
	}
	public void setPromotiondetail(BestProposal1 promotiondetail) {
		this.promotiondetail = promotiondetail;
	}
	private boolean promotionApplied = false;
	private BestProposal1 promotiondetail ;
	private double rateWithoutPromotion;
	public double getRateWithoutPromotion() {
		return rateWithoutPromotion;
	}
	public void setRateWithoutPromotion(double rateWithoutPromotion) {
		this.rateWithoutPromotion = rateWithoutPromotion;
	}
}
