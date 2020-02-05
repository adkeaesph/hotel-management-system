package com.capgemini.hotelscataloguemgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.hotelscataloguemgmtservice.dto.Hotel;
import com.capgemini.hotelscataloguemgmtservice.dto.HotelList;


@RestController
@RequestMapping(path = "/hotel-catalogue")
public class HotelCatalogueSuperController {

	@Autowired
	RestTemplate restTemplate;
	/*
	@PostMapping(path = "/add-hotel")
	public String addHotel(@RequestBody Hotel hotel) {
		
	}
	*/
	@PostMapping(path = "/edit-hotel")
	public String editHotel(@RequestBody Hotel hotel) {
		System.out.println(hotel);
		HttpEntity<Hotel> request = new HttpEntity<>(hotel);
		Hotel hotel2=request.getBody();
		System.out.println(hotel2);
		return restTemplate.postForObject("http://hotels-db-mgmt-service/catalogue/edit-hotel", request, String.class);
	}
	/*
	@PostMapping(path = "/remove-hotel")
	public String removeHotel(@RequestBody Hotel hotel) {
		
	}
	*/
	/*
	@PostMapping(path = "/resurrect-hotel")
	public String resurrectHotel(@RequestBody Hotel hotel) {
		
	}
	*/
	@GetMapping(path = "/get-hotels/{location}")
	public HotelList getHotelsByLocation(@PathVariable("location") String location) {
		HotelList hotelList = restTemplate.getForObject("http://hotels-db-mgmt-service/catalogue/get-hotels/" + location,HotelList.class);
		return hotelList;
	}
}