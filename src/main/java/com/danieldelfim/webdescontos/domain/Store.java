package com.danieldelfim.webdescontos.domain;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;

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
@SequenceGenerator(name = "store_seq", sequenceName = "store_seq", allocationSize = 1, initialValue = 1)
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
	private Long idStore;
	
	@Column(length = 200)
	private Long IdStoreLomadee;

	@Column(length = 200)
	private String nameStore;

	@Column(length = 200)
	private String urlImageStore;

	@Column(length = 200)
	private String linkStore;

	@Column(length = 300)
	private String descriptionStore;

	@Column(length = 50)
	private String urlSeoStore;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "STORE_CATEGORY", joinColumns = { @JoinColumn(name = "store_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	@JsonIgnore
	private List<Category> storeCategories;

}
