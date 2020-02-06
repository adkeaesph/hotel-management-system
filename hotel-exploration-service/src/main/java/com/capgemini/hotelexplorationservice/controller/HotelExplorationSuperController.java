package com.capgemini.hotelexplorationservice.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.hotelexplorationservice.dto.HotelList;
import com.capgemini.hotelexplorationservice.dto.SearchInputs;

@RestController
@RequestMapping(path = "/hotel-explore")

public class HotelExplorationSuperController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(path = "/search-hotel/{location}/{checkInDate}/{checkOutDate}")
	public HotelList getHotelsByInput(@PathVariable("location") String location,
									@PathVariable("checkInDate") Date checkInDate,
									@PathVariable("checkOutDate") Date checkOutDate) {
		HotelList hotelList = restTemplate.getForObject("http://hotels-db-mgmt-service/explore/search-hotel/"+
									location+"/"+checkInDate+"/"+checkOutDate,HotelList.class);
		return hotelList;
	}
	
	@GetMapping(path = "/filter-hotel/{location}/{checkInDate}/{checkOutDate}/{minPrice}/{maxPrice}")
	public HotelList getHotelsByFilter(@PathVariable("location") String location,
			@PathVariable("checkInDate") Date checkInDate,
			@PathVariable("checkOutDate") Date checkOutDate,
			@PathVariable("minPrice") double minPrice,
			@PathVariable("maxPrice") double maxPrice) {
		HotelList hotelList = restTemplate.getForObject("http://hotels-db-mgmt-service/explore/filter-hotel/"+
				location+"/"+checkInDate+"/"+checkOutDate+"/"+minPrice+"/"+maxPrice,HotelList.class);
		return hotelList;
	}

}
