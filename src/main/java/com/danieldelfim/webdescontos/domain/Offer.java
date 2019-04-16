package com.danieldelfim.webdescontos.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 200)
	private String name;
	
	@Column(length = 200)
	private String product;
	
	@Column(length = 50)
	private String linkOffer;
		
	@Column(length = 50)
	private String thumbnail;

	@Column(length = 100)
	private Double price;
	
	@Column(length = 100)
	private String urlSeo;

	@Column(length = 100)
	private Long acess;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(length = 100)
	private Long afiliadoOfferCategoryId;
	
	@Column(length = 100)
	private String afiliadoOfferCategoryName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offerStore_id")
	private Store offerStore;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable ( 
		name = "OFFER_CATEGORY", 
		joinColumns = {@JoinColumn(name = "offer_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "offerCategory_id")})
    @JsonIgnore
	private List<Category> offerCategories;
	
}
