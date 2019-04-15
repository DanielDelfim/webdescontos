package com.danieldelfim.webdescontos.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.repository.CouponRepository;

@RestController
@RequestMapping(value = "/coupons")
public class CouponResources {

	@Autowired
	private CouponRepository couponRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Optional<Coupon> coup = couponRepository.findById(id);
		return ResponseEntity.ok().body(coup);
	}

}