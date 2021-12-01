package com.program.order.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionEngine1 {

	@Autowired
	ActivePromotion1 activePromotions;

	@Autowired
	ProductDetail productDetails;

	public PromtionApplicableDetail1 checkAndApplyPromotion(UserCartDetail1 UserCartDetail1) {

		PromtionApplicableDetail1 promotionApplicableDetail = new PromtionApplicableDetail1();
		Set<Promotion1> promotions = activePromotions.getPromotions();
		BestProposal1 proposal = new BestProposal1();

		boolean promotionApplied = false;
		double rate = 0.0;
		for (Promotion1 promotion : promotions) {
			boolean isApplicable = checkIfPromotionApplicable(UserCartDetail1, promotion);

			while (isApplicable) {

				rate = rate + promotion.getRate();
				if (promotionApplied) {
					if (proposal.getRate() > rate) {
						proposal.setAppliedPromotion(promotion);
						proposal.setRate(rate);
					}
				} else {
					proposal.setAppliedPromotion(promotion);
					
					promotionApplied = true;
				}
				isApplicable = checkIfPromotionApplicable(UserCartDetail1, promotion);
			}
		}

		double finalRate = calculateRate(UserCartDetail1, rate);
		if (promotionApplied) {

			promotionApplicableDetail.setPromotionApplied(true);
			proposal.setRate(finalRate);
			promotionApplicableDetail.setPromotiondetail(proposal);

		} else {

			promotionApplicableDetail.setPromotionApplied(false);
			// double rateWithoutPromition = calculateWithoutPromotionRate(UserCartDetail1);
			promotionApplicableDetail.setPromotiondetail(null);
			promotionApplicableDetail.setRateWithoutPromotion(finalRate);

		}

		return promotionApplicableDetail;

	}

	public boolean checkIfPromotionApplicable(UserCartDetail1 UserCartDetail1, Promotion1 promotion) {
		ArrayList<String> promotionProducts = promotion.getProductDetailsList();
		ArrayList<String> cardProducts = UserCartDetail1.getProductDetailsList();
		boolean isapplicable = true;

		if (!containPromtionProducts(cardProducts, promotionProducts)) {
			return false;

		}

		return isapplicable;

	}

	public Double calculateRate(UserCartDetail1 UserCartDetail1, double existingrate) {

		ArrayList<String> cardProducts = UserCartDetail1.getProductDetailsList();

		HashMap<String, Product> products = productDetails.getProductsDetail();
		if (cardProducts.size() > 0) {
			for (String x : cardProducts) {
				existingrate = existingrate + products.get(x).getRate();
			}
			;
		}

		return existingrate;

	}

	public Double calculateWithoutPromotionRate(UserCartDetail1 UserCartDetail1) {

		ArrayList<String> cardProducts = UserCartDetail1.getProductDetailsList();

		double rate = 0;

		HashMap<String, Product> products = productDetails.getProductsDetail();
		if (cardProducts.size() > 0) {
			for (String x : cardProducts) {
				rate = rate + products.get(x).getRate();
			}
			;
		}

		return rate;

	}

	public boolean containPromtionProducts(ArrayList<String> cardProducts, ArrayList<String> promotionProducts) {
		int i = 0;
		boolean containPromotionProducts = true;
		List<String> cartProductsClone = (ArrayList<String>) cardProducts.clone();
		for (String x : promotionProducts) {
			boolean present = cartProductsClone.contains(x);
			if (present) {
				// promotionProducts.remove(i);
				int index = cartProductsClone.indexOf(x);
				cartProductsClone.remove(index);

			} else {
				return false;
			}

		}
		;

		cardProducts.clear();
		cardProducts.addAll(cartProductsClone);

		return containPromotionProducts;
	}
}
