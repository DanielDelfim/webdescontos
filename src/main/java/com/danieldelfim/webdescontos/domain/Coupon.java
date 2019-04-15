package com.danieldelfim.webdescontos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
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
	private String discount;
		
	@Column(length = 100)
	private String linkCoupon;

	@Column(length = 100)
	private String urlSeo;

	@Column(length = 100)
	private Long acess;
}
