package com.capgemini.hotelsdbmgmtservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelsdbmgmtservice.dto.Hotel;
import com.capgemini.hotelsdbmgmtservice.dto.SearchInputs;
import com.capgemini.hotelsdbmgmtservice.services.HotelExplorationService;

@RestController
@RequestMapping(path = "/explore")
public class HotelExplorationController {
	
	@Autowired
	HotelExplorationService hotelExplorationService;
	
	@GetMapping(path = "/search-hotel")
	public List<Hotel> searchByLocation(@RequestBody SearchInputs input) {
		List<Hotel> hotels=null;
		
		hotels=hotelExplorationService.searchSimple(input);
		
		return hotels;
	}
}
