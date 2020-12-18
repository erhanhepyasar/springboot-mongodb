package com.demo.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.mongo.api.model.Hotel;
import com.demo.spring.mongo.api.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	private HotelRepository hotelRepository;

	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@GetMapping("/all")
	public List<Hotel> getAll() {
		return this.hotelRepository.findAll();
	}
	
	@PutMapping
	public void insert(@RequestBody Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}
	
	@PostMapping
	public void update(@RequestBody Hotel hotel) {
		this.hotelRepository.save(hotel);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.hotelRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Hotel> getById(@PathVariable("id") String id) {
		return hotelRepository.findById(id);
	}
	
	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
		return this.hotelRepository.findByPricePerNightLessThan(maxPrice);		
	}
	
	@GetMapping("/address/{city}")
	public List<Hotel> getByCity(@PathVariable("city") String city) {
		return this.hotelRepository.findByCity(city);
	}

}
