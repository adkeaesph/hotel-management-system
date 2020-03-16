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
	
	@PostMapping(path = "/view-spec-reservations/")
	public ReservationList viewSpecReservations(@RequestBody StayIdList stayIdList) {
		try {
			return staySchedulingService.viewScheduledStays(stayIdList.getStayIds());
		}catch(StaySchedulingException exception) {
			return null;
		}
	}
}
