package com.danieldelfim.webdescontos.parser.lomadee;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponLomadee {
	
	@SerializedName("id")
	@Expose
	public Long id;
	@SerializedName("description")
	@Expose
	public String description;
	@SerializedName("code")
	@Expose
	public String code;
	@SerializedName("discount")
	@Expose
	public Double discount;
	@SerializedName("store")
	@Expose
	public StoreLomadee store;
	@SerializedName("category")
	@Expose
	public CategoryLomadee category;
	@SerializedName("vigency")
	@Expose
	public String vigency;
	@SerializedName("link")
	@Expose
	public String link;
	@SerializedName("new")
	@Expose
	public Boolean _new;

}
