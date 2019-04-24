package com.danieldelfim.webdescontos.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldelfim.webdescontos.domain.Category;
import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.domain.Store;
import com.danieldelfim.webdescontos.parser.lomadee.CouponLomadee;
import com.danieldelfim.webdescontos.parser.lomadee.CouponLomadeeResponse;
import com.danieldelfim.webdescontos.parser.lomadee.ParserLomadeeUtil;
import com.danieldelfim.webdescontos.parser.lomadee.StringToDateUtil;
import com.danieldelfim.webdescontos.repository.CategoryRepository;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.repository.StoreRepository;

@Service
public class ParserLomadeeService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CouponRepository couponRepository;

	private Store getStore(Long id) {
		return storeRepository.findById(id).orElse(null);
	}

	private List<Category> getCategory(Long id) {
		List<Category> categories = new ArrayList<>();
		for (Category category : categoryRepository.findAll()) {
			categories.add(category);
		}
		return categories;
	}

	public void executaParserCouponsLomadee() throws JarException, IOException {

		CouponLomadeeResponse couponLomadeeResponse = ParserLomadeeUtil.getCouponLomadeeResponse();
		for (CouponLomadee couponLomadee : couponLomadeeResponse.getCoupons()) {
			try {
				Coupon.CouponBuilder builder = Coupon.builder();
				builder.id(couponLomadee.getId());
				builder.description(couponLomadee.getDescription());
				builder.code(couponLomadee.getCode());
				builder.discount(couponLomadee.getDiscount());
				builder.endDate(StringToDateUtil.formataData(couponLomadee.getVigency()));
				builder.linkCoupon(couponLomadee.getLink());
				builder.newOrOld(couponLomadee.getNewOrOld());
				builder.couponStore(getStore(1l));
				builder.couponCategories(getCategory(1l));

				couponRepository.save(builder.build());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
