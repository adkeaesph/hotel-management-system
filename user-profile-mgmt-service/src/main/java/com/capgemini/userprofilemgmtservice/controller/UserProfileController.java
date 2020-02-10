package com.capgemini.userprofilemgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.userprofilemgmtservice.customexceptions.AddBookingLogException;
import com.capgemini.userprofilemgmtservice.dto.StayIdListWithEmailId;
import com.capgemini.userprofilemgmtservice.services.UserProfileService;

@RequestMapping(path = "/user-profile")
@RestController
public class UserProfileController {
	@Autowired
	UserProfileService userProfileService;

	@PostMapping("/add-booking-log")
	public String addBookingLog(@RequestBody StayIdListWithEmailId stayIdListWithEmailId) {
		try {
			userProfileService.addBookingLog(stayIdListWithEmailId);
		} catch (AddBookingLogException exception) {
			return exception.getMessage();
		}
		return "Booking log added successfully.";
	}
}
