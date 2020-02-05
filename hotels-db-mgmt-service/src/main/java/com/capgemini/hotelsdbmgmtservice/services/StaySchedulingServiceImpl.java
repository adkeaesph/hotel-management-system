package com.capgemini.hotelsdbmgmtservice.services;

import org.springframework.stereotype.Service;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;

@Service
public class StaySchedulingServiceImpl implements StaySchedulingService{

	@Override
	public boolean scheduleRooms(Reservation reservation) throws StaySchedulingException{
		return true;
	}

	

}
