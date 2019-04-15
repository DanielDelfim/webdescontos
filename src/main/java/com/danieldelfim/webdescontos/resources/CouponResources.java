package com.danieldelfim.webdescontos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danieldelfim.webdescontos.repository.CouponRepository;

@RestController
@RequestMapping(value = "/coupons")
public class CouponResources {

	@Autowired
	private CouponRepository couponRepository;

	public CouponRepository getCouponRepository() {
		return couponRepository;
	}

	public void setCouponRepository(CouponRepository couponRepository) {
		this.couponRepository = couponRepository;
	}

}
