package com.demo.spring.mongo.api.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.mongo.api.model.Address;
import com.demo.spring.mongo.api.model.Hotel;
import com.demo.spring.mongo.api.model.Review;
import com.demo.spring.mongo.api.repository.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner{
	private HotelRepository hotelRepository;
	
	// Constructor Dependency Injection
	public DbSeeder(HotelRepository hotelRepository) {		
		this.hotelRepository = hotelRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Hotel marriot = new Hotel(
			"Marriot",
			130,
			new Address("Paris", "France"),
			Arrays.asList(
					new Review("John", 8, false),
					new Review("Mary", 7, true)
			)
		);

		Hotel ibis = new Hotel(
				"Ibis",
				90,
				new Address("Bucharest", "Romania"),
				Arrays.asList(
						new Review("Teddy", 9, true)
						)
		);
		
		Hotel sofitel = new Hotel(
				"Sofitel",
				200,
				new Address("Rome", "Italy"),
				new ArrayList<>()
		);	
		
		// drop all hotels
		this.hotelRepository.deleteAll();
		
		// add our hotels to the database
		List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
		this.hotelRepository.saveAll(hotels);
	}
	
	
}
