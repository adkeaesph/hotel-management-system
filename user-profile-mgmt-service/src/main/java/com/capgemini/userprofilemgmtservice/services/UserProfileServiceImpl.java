package com.capgemini.userprofilemgmtservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.userprofilemgmtservice.customexceptions.BookingLogException;
import com.capgemini.userprofilemgmtservice.dto.StayIdListWithEmailId;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Override
	public String addBookingLog(StayIdListWithEmailId stayIdListWithEmailId) throws BookingLogException {
		List<Integer> stayIds=stayIdListWithEmailId.getStayIdList().getStayIds();
		String emailID=stayIdListWithEmailId.getEmailId();
		
		return null;
	}

}
