package com.capgemini.hotelsdbmgmtservice.services;

import java.util.List;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;

public interface StaySchedulingService {

	List<Integer> scheduleRooms(List<Reservation> reservations) throws StaySchedulingException;

}
