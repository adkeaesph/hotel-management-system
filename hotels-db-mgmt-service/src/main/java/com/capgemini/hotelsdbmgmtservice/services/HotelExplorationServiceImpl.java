package com.capgemini.hotelsdbmgmtservice.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelsdbmgmtservice.dao.ReadHotelDAO;
import com.capgemini.hotelsdbmgmtservice.dao.ScheduleStayDAO;
import com.capgemini.hotelsdbmgmtservice.dto.Hotel;
import com.capgemini.hotelsdbmgmtservice.dto.SearchInputs;
import com.capgemini.hotelsdbmgmtservice.entities.HotelEntity;
@Service
public class HotelExplorationServiceImpl implements HotelExplorationService {
	
	@Autowired
	ReadHotelDAO readHotelDAO;
	
	@Autowired
	ScheduleStayDAO scheduleStayDAO;
	
	@Override
	public List<Hotel> searchSimple(SearchInputs inputs) {
		// TODO Auto-generated method stub
		String location = inputs.getLocation();
		List<HotelEntity> hotelEntities = readHotelDAO.findByLocation(location);
		String hotelName;
		Hotel hotel;
		int noOfRooms;
		int roomAvailable;
		Date checkIn=inputs.getCheckInDate();
		Date checkOut=inputs.getCheckOutDate();
		List<Hotel> listToBeDisplayed=new ArrayList<>();
		for(HotelEntity hotelEntity:hotelEntities) {
			hotelName=hotelEntity.getHotelName();
			noOfRooms=hotelEntity.getNoOfRooms();
			int occupiedRooms= scheduleStayDAO.findOccupiedRooms(hotelName,checkIn, checkOut).size();
			roomAvailable= noOfRooms-occupiedRooms;	
			if(roomAvailable>0) {
				hotel=new Hotel();
				hotel.setHotelID(hotelEntity.getId());
				hotel.setHotelName(hotelEntity.getHotelName());
				hotel.setLocation(hotelEntity.getLocation());
				hotel.setNoOfRooms(roomAvailable);
				hotel.setPricePerRoom(hotelEntity.getPricePerRoom());
				hotel.setAmenities(hotelEntity.getAmenities());
				listToBeDisplayed.add(hotel);
			}
		}
		
		return listToBeDisplayed;
	}
	
	 

}
