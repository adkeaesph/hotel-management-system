package com.capgemini.userprofilemgmtservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.userprofilemgmtservice.customexceptions.AddBookingLogException;
import com.capgemini.userprofilemgmtservice.dto.Reservation;
import com.capgemini.userprofilemgmtservice.dto.StayIdListWithEmailId;
import com.capgemini.userprofilemgmtservice.services.UserProfileService;
import com.capgemini.userprofilemgmtservice.services.UserService;

@RequestMapping(path = "/user-profile")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserProfileController {
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	UserService userService;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add-booking-log")
	public String addBookingLog(@RequestBody StayIdListWithEmailId stayIdListWithEmailId) {
		try {
			userProfileService.addBookingLog(stayIdListWithEmailId);
		} catch (AddBookingLogException exception) {
			return exception.getMessage();

		}
		return "Booking log added successfully.";
	}

	@GetMapping("/view-my-bookings/{emailID}")
	public List<Reservation> viewMyBookings(@PathVariable("emailID") String emailID) {
		List<Integer> stayIDs = userProfileService.getStayIDs(emailID);
		Reservation reservation = null;
		List<Reservation> reservations = new ArrayList<>();
		for (Integer stayID : stayIDs) {
			System.out.println(stayID);
			reservation = restTemplate.getForObject(
					"http://hotels-db-mgmt-service/schedule-stay/view-reservations/" + stayID, Reservation.class);
			if (reservation != null)
				reservations.add(reservation);
		}
		if (reservations.size() == 0)
			return null;
		return reservations;
	}
}
