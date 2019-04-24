package com.danieldelfim.webdescontos.resources;

import java.io.IOException;
import java.util.jar.JarException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.service.ParserLomadeeService;
import com.danieldelfim.webdescontos.services.DataBaseBuilder;
import com.danieldelfim.webdescontos.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/coupons")
public class CouponResources {

	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private ParserLomadeeService parserLomadeeService;
	
	@Autowired
	private DataBaseBuilder dataBaseBuilder;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Coupon find(@PathVariable Long id) {
		return couponRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + "Tipo: " + Coupon.class.getName()));
	}
	
	@RequestMapping(value = "/parser", method = RequestMethod.GET)
	public void executaParser() throws JarException, IOException {
		parserLomadeeService.executaParserCouponsLomadee();
	}
	
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public void createStores() {
		dataBaseBuilder.createStores();
	}
		
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public void createCategories() {
		dataBaseBuilder.createCategories();
	}

}