package com.capgemini.hotelsdbmgmtservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelFetchingException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelReAdditionException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hotelsdbmgmtservice.dto.Hotel;
import com.capgemini.hotelsdbmgmtservice.dto.HotelList;
import com.capgemini.hotelsdbmgmtservice.services.HotelCatalogueService;

@RequestMapping(path = "/catalogue")
@RestController
public class HotelCatalogueController {

	@Autowired
	HotelCatalogueService hotelCatalogueService;

	@PostMapping(path = "/add-hotel")
	public String addHotel(@RequestBody Hotel hotel) {
		try {
			hotelCatalogueService.createHotel(hotel);
		} catch (HotelCreationException exception) {
			return "Hotel could not be added!!! ";
		}
		return "Hotel added successfully.";
	}

	@PostMapping(path = "/edit-hotel")
	public String editHotel(@RequestBody HttpEntity<Hotel> request) {
		System.out.println("asdsadsfsf");
		try {
			Hotel hotel=request.getBody();
			System.out.println(hotel);
			hotelCatalogueService.updateHotel(request.getBody());
			System.out.println("adks");
		} catch (HotelUpdationException exception) {
			return "Hotel could not be updated!!!";
		}
		return "Hotel updated successfully.";
	}

	@PostMapping(path = "/remove-hotel")
	public String removeHotel(@RequestBody Hotel hotel) {
		try {
			hotelCatalogueService.deleteHotel(hotel);
		} catch (HotelDeletionException exception) {
			return "Hotel could not be removed!!!";
		}
		return "Hotel removed successfully.";
	}

	@PostMapping(path = "/resurrect-hotel")
	public String resurrectHotel(@RequestBody Hotel hotel) {
		try {
			hotelCatalogueService.reAddHotel(hotel);
		} catch (HotelReAdditionException exception) {
			return "Hotel could not be resurrected!!!";
		}
		return "Hotel resurrected successfully.";
	}

	@GetMapping(path = "/get-hotels/{location}")
	public HotelList getHotelsByLocation(@PathVariable("location") String location) {
		List<Hotel> hotels = null;
		HotelList hotelList = null;
		try {
			hotelList = new HotelList();
			hotels = hotelCatalogueService.getHotelsByLocation(location);
			hotelList.setHotels(hotels);
		} catch (HotelFetchingException exception) {
			return hotelList;
		}
		return hotelList;
	}

}
