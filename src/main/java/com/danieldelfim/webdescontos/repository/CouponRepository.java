package com.danieldelfim.webdescontos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.webdescontos.domain.Coupon;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Coupon>{

}
