package com.danieldelfim.webdescontos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danieldelfim.webdescontos.domain.Category;
import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.domain.Store;
import com.danieldelfim.webdescontos.repository.CategoryRepository;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.repository.StoreRepository;

@SpringBootApplication
public class WebdescontosApplication implements CommandLineRunner {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebdescontosApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = Category.builder().id(null).name("informática").urlSeoCategory("informatica").build();
		Category cat2 = Category.builder().id(null).name("Escritório").urlSeoCategory("escritorio").build();

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Store s3 = Store.builder().idStore(null).nameStore("submarino").urlImageStore("www.submarino.com.br")
				.linkStore("www.submarino.com.br").descriptionStore("loja submarino a melhor").urlSeoStore("submarino")
				.storeCategories(Arrays.asList(cat1, cat2)).build();
		Store s4 = Store.builder().idStore(null).nameStore("americanas").urlImageStore("www.americanas.com.br")
				.linkStore("www.americanas.com.br").descriptionStore("loja americanas a melhor")
				.urlSeoStore("americanas").storeCategories(Arrays.asList(cat1, cat2)).build();

		storeRepository.saveAll(Arrays.asList(s3, s4));
			
		Coupon c1 = Coupon.builder().id(null).title("desconto inperdivel").description("melhor desconto")
				.initialDate(null).endDate(null).code(null).discount("10%").linkCoupon("www.submana")
				.urlSeo("submarino").acess(null).couponStore(s3).couponCategories(Arrays.asList(cat1, cat2)).build();
		Coupon c2 = Coupon.builder().id(null).title("melhor desconto").description("loja americanas a melhor")
				.initialDate(null).endDate(null).code("2315").discount("10%").linkCoupon("www.web").urlSeo("americanas")
				.acess(null).couponStore(s4).couponCategories(Arrays.asList(cat1)).build(); 

		couponRepository.saveAll(Arrays.asList(c1, c2));
				
	}

}
