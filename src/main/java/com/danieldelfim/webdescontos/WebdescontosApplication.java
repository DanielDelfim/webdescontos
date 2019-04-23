package com.danieldelfim.webdescontos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danieldelfim.webdescontos.repository.CategoryRepository;
import com.danieldelfim.webdescontos.repository.CouponRepository;
import com.danieldelfim.webdescontos.repository.OfferRepository;
import com.danieldelfim.webdescontos.repository.StoreRepository;

@SpringBootApplication
public class WebdescontosApplication {// implements CommandLineRunner

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private OfferRepository offerRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebdescontosApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Category cat1 = Category.builder().id(null).name("informática").urlSeoCategory("informatica").build();
//		Category cat2 = Category.builder().id(null).name("Escritório").urlSeoCategory("escritorio").build();
//
//		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
//		
//		Store s3 = Store.builder().idStore(null).nameStore("submarino").urlImageStore("www.submarino.com.br")
//				.linkStore("www.submarino.com.br").descriptionStore("loja submarino a melhor").urlSeoStore("submarino")
//				.storeCategories(Arrays.asList(cat1, cat2)).build();
//		Store s4 = Store.builder().idStore(null).nameStore("americanas").urlImageStore("www.americanas.com.br")
//				.linkStore("www.americanas.com.br").descriptionStore("loja americanas a melhor")
//				.urlSeoStore("americanas").storeCategories(Arrays.asList(cat1, cat2)).build();
//
//		storeRepository.saveAll(Arrays.asList(s3, s4));
//			
//		Coupon c1 = Coupon.builder().id(null).title("desconto inperdivel").description("melhor desconto")
//				.initialDate(null).endDate(null).code(null).discount(null).linkCoupon("www.submana")
//				.urlSeo("submarino").acess(null)._new(null).afiliadoCouponCategoryId("2190").afiliadoCouponCategoryName("Informática")
//				.couponStore(s3).couponCategories(Arrays.asList(cat1, cat2)).build();
//		Coupon c2 = Coupon.builder().id(null).title("melhor desconto").description("loja americanas a melhor")
//				.initialDate(null).endDate(null).code("2315").discount(null).linkCoupon("www.web").urlSeo("americanas")
//				.acess(null)._new(null).afiliadoCouponCategoryId("2190").afiliadoCouponCategoryName("Informática").couponStore(s4)
//				.couponCategories(Arrays.asList(cat1)).build(); 
//
//		couponRepository.saveAll(Arrays.asList(c1, c2));
//		
//		Offer o1 = Offer.builder().id(null).name("Imperdível oferta").product("IPHONE").linkOffer("wwwsubmarinoiphone")
//				.thumbnail("imagemsubmarino").price(null).urlSeo("iphone").acess(null).initialDate(null).endDate(null)
//				.afiliadoOfferCategoryId(null).afiliadoOfferCategoryName(null).offerStore(s3).offerCategories(Arrays.asList(cat1, cat2)).build();
//		
//		offerRepository.saveAll(Arrays.asList(o1));
//	}

}
