package com.program.order.model;

import org.springframework.stereotype.Component;

@Component
public class PromtionApplicableDetail {

	public boolean isPromotionApplied() {
		return promotionApplied;
	}
	public void setPromotionApplied(boolean promotionApplied) {
		this.promotionApplied = promotionApplied;
	}
	public BestProposal getPromotiondetail() {
		return promotiondetail;
	}
	public void setPromotiondetail(BestProposal promotiondetail) {
		this.promotiondetail = promotiondetail;
	}
	private boolean promotionApplied = false;
	private BestProposal promotiondetail ;
	private double rateWithoutPromotion;
	public double getRateWithoutPromotion() {
		return rateWithoutPromotion;
	}
	public void setRateWithoutPromotion(double rateWithoutPromotion) {
		this.rateWithoutPromotion = rateWithoutPromotion;
	}
}
