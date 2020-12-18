package com.demo.spring.mongo.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Review {
	private String userName;
	private int rating;
	private boolean approved;
	
	protected Review() {
		
	}

}
