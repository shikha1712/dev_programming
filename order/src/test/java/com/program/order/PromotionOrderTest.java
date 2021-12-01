package com.program.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.program.order.model.PromotionEngine;
import com.program.order.model.PromotionEngine1;
import com.program.order.model.PromtionApplicableDetail;
import com.program.order.model.PromtionApplicableDetail1;
import com.program.order.model.UserCartDetail;
import com.program.order.model.UserCartDetail1;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionOrderTest {

	@Test
	void contextLoads() {
	}

	@Autowired
	PromotionEngine1 promotionEngine;

	@Test
	public void testPromtionOrderTestCase1() {
		UserCartDetail1 userCartDetail = new UserCartDetail1();

		List<String> products = new ArrayList();
		products.add("A");
		products.add("B");
		products.add("C");
		userCartDetail.setProductDetailsList((ArrayList<String>) products);
		// products.add("D");

		/**
		 * products.forEach(x -> {
		 * 
		 * if (productDetail.get(x) != null) { Long count = productDetail.get(x);
		 * productDetail.put(x, count + 1); } else { productDetail.put(x, (long) 1); }
		 * 
		 * });
		 **/

		PromtionApplicableDetail1 promtionApplicableDetail = promotionEngine.checkAndApplyPromotion(userCartDetail);
		if (promtionApplicableDetail.isPromotionApplied()) {
			System.out.println(promtionApplicableDetail.getPromotiondetail().getRate());
		} else {
			System.out.println(promtionApplicableDetail.getRateWithoutPromotion());
		}

	}

	@Test
	public void testPromtionOrderTestCase2() {
		UserCartDetail1 userCartDetail = new UserCartDetail1();
		// HashMap<String, Long> productDetail = userCartDetail.getProductDetails();
		List<String> products = new ArrayList();
		products.add("A");
		products.add("A");
		products.add("A");
		products.add("A");
		products.add("A");

		products.add("B");
		products.add("B");
		products.add("B");
		products.add("B");
		products.add("B");

		products.add("C");
		userCartDetail.setProductDetailsList((ArrayList<String>) products);
		// products.add("D");

		/**
		 * products.forEach(x -> {
		 * 
		 * if (productDetail.get(x) != null) { Long count = productDetail.get(x);
		 * productDetail.put(x, count + 1); } else { productDetail.put(x, (long) 1); }
		 * 
		 * });
		 **/

		PromtionApplicableDetail1 promtionApplicableDetail = promotionEngine.checkAndApplyPromotion(userCartDetail);
		if (promtionApplicableDetail.isPromotionApplied()) {
			System.out.println(promtionApplicableDetail.getPromotiondetail().getRate());
		} else {
			System.out.println(promtionApplicableDetail.getRateWithoutPromotion());
		}

	}

	@Test
	public void testPromtionOrderTestCase3() {
		UserCartDetail1 userCartDetail = new UserCartDetail1();
		// HashMap<String, Long> productDetail = userCartDetail.getProductDetails();
		List<String> products = new ArrayList();
		products.add("A");
		products.add("A");
		products.add("A");

		products.add("B");
		products.add("B");
		products.add("B");
		products.add("B");
		products.add("B");

		products.add("C");
		products.add("D");
		userCartDetail.setProductDetailsList((ArrayList<String>) products);
		// products.add("D");

		/**
		 * products.forEach(x -> {
		 * 
		 * if (productDetail.get(x) != null) { Long count = productDetail.get(x);
		 * productDetail.put(x, count + 1); } else { productDetail.put(x, (long) 1); }
		 * 
		 * });
		 **/

		PromtionApplicableDetail1 promtionApplicableDetail = promotionEngine.checkAndApplyPromotion(userCartDetail);
		if (promtionApplicableDetail.isPromotionApplied()) {
			System.out.println(promtionApplicableDetail.getPromotiondetail().getRate());
		} else {
			System.out.println(promtionApplicableDetail.getRateWithoutPromotion());
		}

	}

}
