package com.capgemini.bookingmgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bookingmgmtservice.dto.BookingLogDetails;
import com.capgemini.bookingmgmtservice.dto.ReservationList;
import com.capgemini.bookingmgmtservice.dto.StayIdList;
import com.capgemini.bookingmgmtservice.dto.StayIdListWithEmailId;

@RequestMapping(path = "/hotel-booking")
@CrossOrigin("http://localhost:4200")
@RestController
public class BookingController {
	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/reserve-rooms")
	public String reserveRooms(@RequestBody BookingLogDetails bookingLogDetails) {
		ReservationList reservationList = new ReservationList();
		reservationList.setReservations(bookingLogDetails.getReservations());
		StayIdList stayIdList = restTemplate.postForObject("http://hotels-db-mgmt-service/schedule-stay/allocate-rooms",
				reservationList, StayIdList.class);
		if (stayIdList != null) {
			StayIdListWithEmailId stayIdListWithEmailId = new StayIdListWithEmailId(stayIdList,
					bookingLogDetails.getEmailId());
			String result = restTemplate.postForObject("http://user-service/user-profile/add-booking-log",
					stayIdListWithEmailId, String.class);
			if (result.indexOf("successfully") >= 0)
				return "Reservation of room(s) successful.";
			else
				return "Reservation of room(s) failed!!!";
		} else
			return "Reservation of room(s) failed!!!";
	}
}
