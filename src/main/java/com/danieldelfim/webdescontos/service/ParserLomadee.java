package com.danieldelfim.webdescontos.service;

import java.io.IOException;
import java.util.jar.JarException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldelfim.webdescontos.domain.Category;
import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.parser.lomadee.CouponLomadee;
import com.danieldelfim.webdescontos.parser.lomadee.CouponLomadeeResponse;
import com.danieldelfim.webdescontos.parser.lomadee.ParserLomadeeUtil;
import com.danieldelfim.webdescontos.repository.CategoryRepository;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.repository.StoreRepository;

@Service
public class ParserLomadee {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CouponRepository couponRepository;

	public void executaParserCoupons() {
		
		try {
			CouponLomadeeResponse couponLomadeeResponse = ParserLomadeeUtil.getCouponLomadeeResponse();
			for (CouponLomadee couponLomadee : couponLomadeeResponse.getCoupons()) {
				Coupon.CouponBuilder builder = Coupon.builder();
				builder.id(couponLomadee.id);
				builder.description(couponLomadee.getDescription());
				builder.code(couponLomadee.getCode());
				builder.discount(couponLomadee.discount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
