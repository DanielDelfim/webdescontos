package com.danieldelfim.webdescontos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.webdescontos.domain.Coupon;
import com.danieldelfim.webdescontos.domain.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Store>{

}
