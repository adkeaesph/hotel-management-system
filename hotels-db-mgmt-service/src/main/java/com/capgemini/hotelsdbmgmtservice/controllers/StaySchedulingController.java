package com.capgemini.hotelsdbmgmtservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;
import com.capgemini.hotelsdbmgmtservice.dto.ReservationList;
import com.capgemini.hotelsdbmgmtservice.dto.StayIdList;
import com.capgemini.hotelsdbmgmtservice.services.StaySchedulingService;

@RequestMapping(path = "/schedule-stay")
@RestController
public class StaySchedulingController {

	@Autowired
	StaySchedulingService staySchedulingService;

	@PostMapping(path = "/allocate-rooms")
	public StayIdList allocateRoom(@RequestBody ReservationList reservationList) {
		List<Integer> stayIds=null;
		StayIdList stayIdList=new StayIdList();
		try {
			stayIds=staySchedulingService.scheduleRooms(reservationList.getReservations());
			stayIdList.setStayIds(stayIds);
		} catch (StaySchedulingException exception) {
			return null;
		}
		return stayIdList;
	}
	
	@GetMapping(path = "/view-reservations/{stayID}")
	public Reservation viewReservations(@PathVariable("stayID") Integer stayID) {
		try {
			return staySchedulingService.viewScheduledStays(stayID);
		}catch(StaySchedulingException exception) {
			return null;
		}
	}
	
	@GetMapping(path = "/view-spec-reservations/{stayIDs}")
	public ReservationList viewSpecReservations(@PathVariable("stayIDs") List<Integer> stayIDs) {
		try {
			return staySchedulingService.viewScheduledStays(stayIDs);
		}catch(StaySchedulingException exception) {
			return null;
		}
	}
}
