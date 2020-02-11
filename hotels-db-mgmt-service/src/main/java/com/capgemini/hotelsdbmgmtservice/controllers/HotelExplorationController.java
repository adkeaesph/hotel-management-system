package com.capgemini.hotelsdbmgmtservice.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelsdbmgmtservice.dto.Hotel;
import com.capgemini.hotelsdbmgmtservice.dto.HotelList;
import com.capgemini.hotelsdbmgmtservice.dto.SearchInputs;
import com.capgemini.hotelsdbmgmtservice.services.HotelExplorationService;

@RestController
@RequestMapping(path = "/explore")
public class HotelExplorationController {

	@Autowired
	HotelExplorationService hotelExplorationService;

	@GetMapping(path = "/search-hotel/{location}/{checkInDate}/{checkOutDate}")
	public HotelList searchByLocation(@PathVariable("location") String location,
			@PathVariable("checkInDate") Date checkInDate, @PathVariable("checkOutDate") Date checkOutDate) {
		List<Hotel> hotels = null;
		SearchInputs input = new SearchInputs(location, checkInDate, checkOutDate);
		hotels = hotelExplorationService.searchSimple(input);
		HotelList hotelList = new HotelList();
		hotelList.setHotels(hotels);
		return hotelList;
	}

	@GetMapping(path = "/filter-hotel/{location}/{checkInDate}/{checkOutDate}/{minPrice}/{maxPrice}")
	public HotelList searchByFilter(@PathVariable("location") String location,
			@PathVariable("checkInDate") Date checkInDate, @PathVariable("checkOutDate") Date checkOutDate,
			@PathVariable("minPrice") double minPrice, @PathVariable("maxPrice") double maxPrice) {
		List<Hotel> hotelss = null;
		SearchInputs input = new SearchInputs(location, checkInDate, checkOutDate, minPrice, maxPrice);
		hotelss = hotelExplorationService.searchFilter(input);
		HotelList hotelList = new HotelList();
		hotelList.setHotels(hotelss);
		return hotelList;
	}

}
