package com.capgemini.hotelsdbmgmtservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelFetchingException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelReAdditionException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hotelsdbmgmtservice.dao.WriteHotelDAO;
import com.capgemini.hotelsdbmgmtservice.dto.Hotel;
import com.capgemini.hotelsdbmgmtservice.entities.HotelEntity;
@Service
public class HotelCatalogueServiceImpl implements HotelCatalogueService {

	@Autowired
	WriteHotelDAO writeHotelDAO;
	
	@Override
	public boolean createHotel(Hotel hotel) throws HotelCreationException{
		int rows=(int)writeHotelDAO.count();
		HotelEntity hotelEntity=new HotelEntity();
		hotelEntity.setId(rows+1);
		hotelEntity.setHotelName(hotel.getHotelName());
		hotelEntity.setLocation(hotel.getLocation());
		hotelEntity.setNoOfRooms(hotel.getNoOfRooms());
		hotelEntity.setPricePerRoom(hotel.getPricePerRoom());
		hotelEntity.setAmenities(hotel.getAmenities());
		hotelEntity.setActiveStatus(true);
		try {
			writeHotelDAO.save(hotelEntity);
		}catch(Exception exception) {
			throw new HotelCreationException(exception.getMessage());
		}
		return true;
	}

	@Override
	public boolean updateHotel(Hotel hotel) throws HotelUpdationException {
		Optional<HotelEntity> hotelToBeUpdated=writeHotelDAO.findById(hotel.getHotelID());
		if(hotelToBeUpdated.isPresent()) {
			HotelEntity hotelEntityToBeUpdated=hotelToBeUpdated.get();
			if (hotel.getHotelName() != null && !hotel.getHotelName().equals(hotelEntityToBeUpdated.getHotelName())) 
				hotelEntityToBeUpdated.setHotelName(hotel.getHotelName());
			if (hotel.getLocation() != null && !hotel.getLocation().equals(hotelEntityToBeUpdated.getLocation()))
				hotelEntityToBeUpdated.setLocation(hotel.getLocation());
			if (hotel.getNoOfRooms() != 0 && hotel.getNoOfRooms()!=hotelEntityToBeUpdated.getNoOfRooms())
				hotelEntityToBeUpdated.setNoOfRooms(hotel.getNoOfRooms());
			if (hotel.getPricePerRoom() != 0)
				hotelEntityToBeUpdated.setPricePerRoom(hotel.getPricePerRoom());
			if(hotel.getAmenities()!=null && !hotel.getAmenities().equals(hotelEntityToBeUpdated.getAmenities()))
				hotelEntityToBeUpdated.setAmenities(hotel.getAmenities());
			try {
				writeHotelDAO.save(hotelEntityToBeUpdated);
			}catch(Exception exception) {
				throw new HotelUpdationException(exception.getMessage());
			}
		}else {
			throw new HotelUpdationException("Hotel with the given id does not exist!!!");
		}
		return true;
	}

	@Override
	public boolean deleteHotel(Hotel hotel) throws HotelDeletionException {
		Optional<HotelEntity> hotelToBeDeleted=writeHotelDAO.findById(hotel.getHotelID());
		if(hotelToBeDeleted.isPresent()) {
			HotelEntity hotelEntityToBeDeleted=hotelToBeDeleted.get();
			if(hotelEntityToBeDeleted.isActive())
				hotelEntityToBeDeleted.setActiveStatus(false);
			else
				throw new HotelDeletionException("Hotel already removed!!!");
			try {
				writeHotelDAO.save(hotelEntityToBeDeleted);
			}catch(Exception exception) {
				throw new HotelDeletionException(exception.getMessage());
			}
		}else {
			throw new HotelDeletionException("Hotel with the given id does not exist!!!");
		}
		return true;
	}

	@Override
	public boolean reAddHotel(Hotel hotel) throws HotelReAdditionException {
		Optional<HotelEntity> hotelToBeReAdded=writeHotelDAO.findById(hotel.getHotelID());
		if(hotelToBeReAdded.isPresent()) {
			HotelEntity hotelEntityToBeReAdded=hotelToBeReAdded.get();
			if(!hotelEntityToBeReAdded.isActive())
				hotelEntityToBeReAdded.setActiveStatus(true);
			else
				throw new HotelReAdditionException("Hotel already exists!!!");
			try {
				writeHotelDAO.save(hotelEntityToBeReAdded);
			}catch(Exception exception) {
				throw new HotelReAdditionException(exception.getMessage());
			}
		}else {
			throw new HotelReAdditionException("Hotel with the given id does not exist!!!");
		}
		return true;
	}

	@Override
	public List<Hotel> getHotelsByLocation(String location) throws HotelFetchingException {
		List<HotelEntity> hotelEntities=writeHotelDAO.findByLocation(location);
		List<Hotel> hotels=null;
		Hotel currentHotel;
		if(hotelEntities.size()!=0) {
			hotels=new ArrayList<>();
			for(HotelEntity hotelEntity:hotelEntities) {
				currentHotel=new Hotel();
				currentHotel.setAmenities(hotelEntity.getAmenities());
				currentHotel.setHotelName(hotelEntity.getHotelName());
				currentHotel.setHotelID(hotelEntity.getId());
				currentHotel.setLocation(hotelEntity.getLocation());
				currentHotel.setNoOfRooms(hotelEntity.getNoOfRooms());
				currentHotel.setPricePerRoom(hotelEntity.getPricePerRoom());
				hotels.add(currentHotel);
			}
		}else
			throw new HotelFetchingException("No rows by the given location fetched!!!");
		return hotels;
	}
	
	

}
