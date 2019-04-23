package com.danieldelfim.webdescontos.domain;

import java.io.Serializable;
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
public class Coupon  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 200)
	private String title;
	
	@Column(length = 200)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(length = 50)
	private String code;
		
	@Column(length = 50)
	private Double discount;
		
	@Column(length = 100)
	private String linkCoupon;

	@Column(length = 100)
	private String urlSeo;

	@Column(length = 100)
	private Long acess;
	
	@Column(length = 100)
	private Boolean newOrOld;
	
	@Column(length = 100)
	private String afiliadoCouponCategoryId;
	
	@Column(length = 100)
	private String afiliadoCouponCategoryName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "couponStore_id")
	private Store couponStore;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable ( 
		name = "COUPON_CATEGORY", 
		joinColumns = {@JoinColumn(name = "coupon_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "couponCategory_id")})
    @JsonIgnore
	private List<Category> couponCategories;

} 

