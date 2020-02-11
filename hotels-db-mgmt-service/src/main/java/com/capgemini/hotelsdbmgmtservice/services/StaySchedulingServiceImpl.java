package com.capgemini.hotelsdbmgmtservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dao.ScheduledStayDAO;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;
import com.capgemini.hotelsdbmgmtservice.dto.ReservationList;
import com.capgemini.hotelsdbmgmtservice.entities.ScheduledStayEntity;

@Service
public class StaySchedulingServiceImpl implements StaySchedulingService{

	@Autowired
	ScheduledStayDAO scheduledStayDAO;
	
	@Override
	public List<Integer> scheduleRooms(List<Reservation> reservations) throws StaySchedulingException{
		ScheduledStayEntity scheduledStayEntity;
		int rows=(int)scheduledStayDAO.count();
		
		List<Integer> stayIds=new ArrayList<>();
		for(Reservation reservation:reservations) {
			scheduledStayEntity=new ScheduledStayEntity();
			scheduledStayEntity.setStayId(++rows);
			stayIds.add(rows);
			scheduledStayEntity.setHotelID(reservation.getHotelID());
			scheduledStayEntity.setGuestName(reservation.getGuestName());
			scheduledStayEntity.setNoOfGuests(reservation.getNoOfGuests());
			scheduledStayEntity.setPhoneNo(reservation.getPhoneNo());
			scheduledStayEntity.setCheckInDate(reservation.getCheckinDate());
			scheduledStayEntity.setCheckOutDate(reservation.getCheckoutDate());
			try {
				scheduledStayDAO.save(scheduledStayEntity);
			}catch(Exception exception) {
				throw new StaySchedulingException("Room could not be allocated!!!");
			}
		}
		return stayIds;
	}
	
	@Override
	public Reservation viewScheduledStays(Integer stayID) throws StaySchedulingException {
		Reservation reservation = new Reservation();
		ScheduledStayEntity scheduledStayEntity = scheduledStayDAO.findById(stayID).get();
		reservation.setHotelID(scheduledStayEntity.getHotelID());
		reservation.setGuestName(scheduledStayEntity.getGuestName());
		reservation.setNoOfGuests(scheduledStayEntity.getNoOfGuests());
		reservation.setPhoneNo(scheduledStayEntity.getPhoneNo());
		reservation.setCheckinDate(scheduledStayEntity.getCheckInDate());
		reservation.setCheckoutDate(scheduledStayEntity.getCheckOutDate());

		if (reservation.getGuestName() == null)
			throw new StaySchedulingException("No room scheduled as allocated!!!");

		return reservation;
	}

	@Override
	public ReservationList viewScheduledStays(List<Integer> stayIDs) throws StaySchedulingException {
		List<Reservation> reservations=new ArrayList<>();
		for(Integer stayID:stayIDs) {
			Reservation reservation = new Reservation();
			ScheduledStayEntity scheduledStayEntity = scheduledStayDAO.findById(stayID).get();
			reservation.setHotelID(scheduledStayEntity.getHotelID());
			reservation.setGuestName(scheduledStayEntity.getGuestName());
			reservation.setNoOfGuests(scheduledStayEntity.getNoOfGuests());
			reservation.setPhoneNo(scheduledStayEntity.getPhoneNo());
			reservation.setCheckinDate(scheduledStayEntity.getCheckInDate());
			reservation.setCheckoutDate(scheduledStayEntity.getCheckOutDate());
	
			if (reservation.getGuestName() == null)
				throw new StaySchedulingException("No room scheduled as allocated!!!");
			
			reservations.add(reservation);
		}
		if(reservations.size()==0)
			return null;
		ReservationList reservationList=new ReservationList();
		reservationList.setReservations(reservations);
		return reservationList;
	}
}
