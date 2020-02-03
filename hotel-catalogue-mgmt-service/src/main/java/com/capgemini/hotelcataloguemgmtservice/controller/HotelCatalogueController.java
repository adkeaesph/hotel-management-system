package com.capgemini.hotelcataloguemgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hotelcataloguemgmtservice.dto.Hotel;
import com.capgemini.hotelcataloguemgmtservice.services.HotelCatalogueService;

@RestController
@RequestMapping(path = "/catalogue")
public class HotelCatalogueController {

	@Autowired
	HotelCatalogueService hotelCatalogueService;
	
	@PostMapping(path = "/add-hotel")
	public String addHotel(@RequestBody Hotel hotel) {
		try {
			hotelCatalogueService.createHotel(hotel);
		}catch(HotelCreationException exception) {
			return "Hotel could not be added!!!";
		}
		return "Hotel added successfully.";
	}
	
	@PostMapping(path = "/edit-hotel")
	public String editHotel(@RequestBody Hotel hotel) {
		try {
			hotelCatalogueService.updateHotel(hotel);
		}catch(HotelUpdationException exception) {
			return "Hotel could not be updated!!!";
		}
		return "Hotel updated successfully.";
	}
	
	@PostMapping(path = "/delete-hotel")
	public String removeHotel(@RequestBody Hotel hotel) {
		try {
			hotelCatalogueService.deleteHotel(hotel);
		}catch(HotelDeletionException exception) {
			return "Hotel could not be removed!!!";
		}
		return "Hotel removed successfully.";
	}
}
