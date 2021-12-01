package com.program.order.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionEngine {

	@Autowired
	ActivePromotion activePromotions;

	@Autowired
	ProductDetail productDetails;

	public PromtionApplicableDetail checkAndApplyPromotion(UserCartDetail userCartDetail) {

		PromtionApplicableDetail promotionApplicableDetail = new PromtionApplicableDetail();
		Set<Promotion> promotions = activePromotions.getPromotions();
		BestProposal proposal = new BestProposal();

		boolean promotionApplied = false;
		for (Promotion promotion : promotions) {
			boolean isApplicable = checkIfPromotionApplicable(userCartDetail, promotion);
			if (isApplicable) {

				promotionApplied = true;
				double rate = calculateRate(userCartDetail, promotion);
				if (proposal.getRate() > rate) {
					proposal.setAppliedPromotion(promotion);
					proposal.setRate(rate);
				}
			}
		}

		if (promotionApplied) {

			promotionApplicableDetail.setPromotionApplied(true);
			promotionApplicableDetail.setPromotiondetail(proposal);

		} else {

			promotionApplicableDetail.setPromotionApplied(false);
			double rateWithoutPromition = calculateWithoutPromotionRate(userCartDetail);
			promotionApplicableDetail.setPromotiondetail(null);
			promotionApplicableDetail.setRateWithoutPromotion(rateWithoutPromition);

		}

		return promotionApplicableDetail;

	}

	public boolean checkIfPromotionApplicable(UserCartDetail userCartDetail, Promotion promotion) {
		Set<String> productRequiredInPromtion = promotion.getProducts().keySet();
		Set<String> productPresentInCart = userCartDetail.getProductDetails().keySet();
		boolean isapplicable = true;

		for (String product : productPresentInCart) {
			if (!productRequiredInPromtion.contains(product)) {
				return false;
			} else {
				Long countRequired = promotion.getProducts().get(product);
				Long countPresent = userCartDetail.getProductDetails().get(product);
				{
					if (!(countPresent >= countRequired)) {
						return false;
					}
				}
			}
		}

		return isapplicable;

	}

	public Double calculateRate(UserCartDetail userCartDetail, Promotion promotion) {

		ArrayList<String> cardProducts = new ArrayList<>();
		ArrayList<String> promotionProducts = new ArrayList<>();

		Double rate = 0.0;
		userCartDetail.getProductDetails().entrySet().forEach(x -> {
			Long count = x.getValue();
			while (count > 0) {
				cardProducts.add(x.getKey());
				count--;

			}
		});

		promotion.getProducts().entrySet().forEach(x -> {
			Long count = x.getValue();
			while (count > 0) {
				promotionProducts.add(x.getKey());
				count--;

			}
		});

		while (cardProducts.containsAll(promotionProducts)) {
			cardProducts.removeAll(promotionProducts);
			rate = rate + promotion.getRate();

		}

		HashMap<String, Product> products = productDetails.getProductsDetail();
		if (cardProducts.size() > 0) {
			for (String x : cardProducts) {
				rate = rate + products.get(x).getRate();
			}
			;
		}

		return rate;

	}

	public Double calculateWithoutPromotionRate(UserCartDetail userCartDetail) {

		ArrayList<String> cardProducts = new ArrayList<>();

		double rate = 0;

		userCartDetail.getProductDetails().entrySet().forEach(x -> {
			Long count = x.getValue();
			while (count > 0) {
				cardProducts.add(x.getKey());
				count--;

			}
		});

		HashMap<String, Product> products = productDetails.getProductsDetail();
		if (cardProducts.size() > 0) {
			for (String x : cardProducts) {
				rate = rate + products.get(x).getRate();
			}
			;
		}

		return rate;

	}

}
