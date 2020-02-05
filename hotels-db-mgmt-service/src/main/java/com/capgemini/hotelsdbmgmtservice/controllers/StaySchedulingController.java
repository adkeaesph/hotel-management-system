package com.capgemini.hotelsdbmgmtservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;
import com.capgemini.hotelsdbmgmtservice.services.StaySchedulingService;

@RequestMapping(path = "/room-allocation")
@RestController
public class StaySchedulingController {

	@Autowired
	StaySchedulingService staySchedulingService;

	@PostMapping(path = "/")
	public String allocateRoom(@RequestBody Reservation reservation) {
		try {
			staySchedulingService.scheduleRooms(reservation);
		} catch (StaySchedulingException exception) {
			return "Room(s) could not be allocated!!!";
		}
		return "Room(s) allocated successfully.";
	}
}
