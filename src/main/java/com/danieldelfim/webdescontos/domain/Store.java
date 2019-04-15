package com.danieldelfim.webdescontos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 200)
	private String name;
	
	@Column(length = 200)
	private String urlImage;

	@Column(length = 200)
	private String link;

	@Column(length = 200)
	private String description;

	@Column(length = 50)
	private String urlSeoStore;
}
