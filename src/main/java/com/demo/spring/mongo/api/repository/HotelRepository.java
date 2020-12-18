package com.demo.spring.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.spring.mongo.api.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{
	public List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value = "{\"address.city\":?0}")
	List<Hotel> findByCity(String city);
}
