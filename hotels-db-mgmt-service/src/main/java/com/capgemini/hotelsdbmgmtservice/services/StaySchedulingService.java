package com.capgemini.hotelsdbmgmtservice.services;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;

public interface StaySchedulingService {

	boolean scheduleRooms(Reservation reservation) throws StaySchedulingException;

}
