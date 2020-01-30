package com.capgemini.hotelcataloguemgmtservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelcataloguemgmtservice.dto.Hotel;

@RestController
@RequestMapping(path = "/catalogue")
public class HotelCatalogueController {

	@PostMapping(path = "/{qId}")
	public String addHotel(@RequestBody Hotel hotel) {

		return null;
	}
}
