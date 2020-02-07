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
		List<ScheduledStayEntity> occupiedRoomEntities= new ArrayList<>();
		Reservation firstReservation=reservations.get(0);
		occupiedRoomEntities=scheduledStayDAO.findOccupiedRooms(firstReservation.getHotelID(),
				firstReservation.getCheckinDate(), firstReservation.getCheckoutDate());
		int rows=(int)scheduledStayDAO.count();
		int noOfRoomsToBeAllocated=reservations.size();
		int[] vacantRoomIds=new int[noOfRoomsToBeAllocated];
		int i=1;
		int j=0;
		for(ScheduledStayEntity entity:occupiedRoomEntities) {
			if(i!=entity.getRoomId()) {
				vacantRoomIds[j]=i;
				j++;
				if(j==noOfRoomsToBeAllocated)
					break;
			}
			i++;
		}
		j=0;
		List<Integer> stayIds=new ArrayList<>();
		for(Reservation reservation:reservations) {
			scheduledStayEntity=new ScheduledStayEntity();
			scheduledStayEntity.setStayId(++rows);
			stayIds.add(rows);
			scheduledStayEntity.setRoomId(vacantRoomIds[j++]);
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
