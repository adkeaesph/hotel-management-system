package com.capgemini.hotelsdbmgmtservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelsdbmgmtservice.customexceptions.StaySchedulingException;
import com.capgemini.hotelsdbmgmtservice.dao.ScheduledStayDAO;
import com.capgemini.hotelsdbmgmtservice.dto.Reservation;
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
}
