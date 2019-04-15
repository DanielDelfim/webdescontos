package com.danieldelfim.webdescontos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.domain.Store;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.repository.StoreRepository;

@SpringBootApplication
public class WebdescontosApplication implements CommandLineRunner {
	
	@Autowired
	CouponRepository couponRepository;

	@Autowired
	StoreRepository storeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WebdescontosApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Coupon c1 = new Coupon(null, "desconto imperdivel", "loja submarino a melhor", null, null, "2316", "10%", "www.web", "informatica", null);
		Coupon c2 = new Coupon(null, "melhor desconto", "loja americanas a melhor", null, null, "2315", "10%", "www.web", "escritorio", null);
		
		Store s3 = new Store(null, "submarino", "www.submarino.com.br", "www.submarino.com.br", "loja submarino a melhor", "submarino");

		couponRepository.saveAll(Arrays.asList(c1, c2));
		storeRepository.saveAll(Arrays.asList(s3));
	}

}
