package com.danieldelfim.webdescontos.parser.lomadee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreLomadee {

	@SerializedName("id")
	@Expose
	public Long id;
	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("image")
	@Expose
	public String image;
	@SerializedName("link")
	@Expose
	public String link;
	
}
