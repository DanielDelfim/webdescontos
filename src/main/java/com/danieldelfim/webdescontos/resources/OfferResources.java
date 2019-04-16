package com.danieldelfim.webdescontos.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldelfim.webdescontos.domain.Offer;
import com.danieldelfim.webdescontos.repository.OfferRepository;

@RestController
@RequestMapping(value = "/offers")
public class OfferResources {

	@Autowired
	private OfferRepository offerRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Optional<Offer> offer = offerRepository.findById(id);
		return ResponseEntity.ok().body(offer);
	}

}