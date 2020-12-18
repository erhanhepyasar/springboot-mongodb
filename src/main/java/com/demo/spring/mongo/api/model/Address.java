package com.demo.spring.mongo.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {
	private String city;
	private String country;
	
	protected Address() {}
	
	

}
