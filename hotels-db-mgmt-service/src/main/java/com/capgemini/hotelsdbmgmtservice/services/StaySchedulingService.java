package com.capgemini.hotelsdbmgmtservice.services;

import java.util.List;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;
import com.capgemini.hotelsdbmgmtservice.dto.ReservationList;

public interface StaySchedulingService {
	List<Integer> scheduleRooms(List<Reservation> reservations) throws StaySchedulingException;
	Reservation viewScheduledStays(Integer stayID) throws StaySchedulingException;
	ReservationList viewScheduledStays(List<Integer> stayIDs) throws StaySchedulingException;
}
