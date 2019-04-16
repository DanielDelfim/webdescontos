package com.danieldelfim.webdescontos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/coupons")
public class CouponResources {

	@Autowired
	private CouponRepository couponRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Coupon find(@PathVariable Long id) {
		return couponRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + "Tipo: " + Coupon.class.getName()));
	}

}