package com.capgemini.userprofilemgmtservice.services;

import java.util.List;

import com.capgemini.userprofilemgmtservice.customexceptions.BookingLogException;
import com.capgemini.userprofilemgmtservice.dto.StayIdListWithEmailId;

public interface UserProfileService {

	String addBookingLog(StayIdListWithEmailId stayIdListWithEmailId) throws BookingLogException;

}
