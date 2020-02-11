package com.capgemini.hotelexplorationservice.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.hotelexplorationservice.dto.HotelList;
import com.capgemini.hotelexplorationservice.dto.Hotel;
import com.capgemini.hotelexplorationservice.dto.SearchInputs;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/hotel-explore")

public class HotelExplorationSuperController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(path = "/search-hotel/{location}/{checkInDate}/{checkOutDate}")
	public List<Hotel> getHotelsByInput(@PathVariable("location") String location,
									@PathVariable("checkInDate") Date checkInDate,
									@PathVariable("checkOutDate") Date checkOutDate) {
		HotelList hotelList = restTemplate.getForObject("http://hotels-db-mgmt-service/explore/search-hotel/"+
									location+"/"+checkInDate+"/"+checkOutDate,HotelList.class);
		return hotelList.getHotels();
	}
	
	@GetMapping(path = "/filter-hotel/{location}/{checkInDate}/{checkOutDate}/{minPrice}/{maxPrice}")
	public List<Hotel> getHotelsByFilter(@PathVariable("location") String location,
			@PathVariable("checkInDate") Date checkInDate,
			@PathVariable("checkOutDate") Date checkOutDate,
			@PathVariable("minPrice") double minPrice,
			@PathVariable("maxPrice") double maxPrice) {
		HotelList hotelList = restTemplate.getForObject("http://hotels-db-mgmt-service/explore/filter-hotel/"+
				location+"/"+checkInDate+"/"+checkOutDate+"/"+minPrice+"/"+maxPrice,HotelList.class);
		return hotelList.getHotels();
	}

}
