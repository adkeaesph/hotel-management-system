package com.capgemini.userprofilemgmtservice.services;

import java.util.List;

import com.capgemini.userprofilemgmtservice.customexceptions.AddBookingLogException;
import com.capgemini.userprofilemgmtservice.dto.StayIdListWithEmailId;

public interface UserProfileService {
	boolean addBookingLog(StayIdListWithEmailId stayIdListWithEmailId) throws AddBookingLogException;
	List<Integer> getStayIDs(String emailID);
}
