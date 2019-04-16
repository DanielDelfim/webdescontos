package com.danieldelfim.webdescontos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.webdescontos.domain.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{
	
}
