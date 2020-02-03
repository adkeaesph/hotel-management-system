package com.capgemini.hotelcataloguemgmtservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hotelcataloguemgmtservice.dao.HotelDAO;
import com.capgemini.hotelcataloguemgmtservice.dao.PicDAO;
import com.capgemini.hotelcataloguemgmtservice.dto.Hotel;
import com.capgemini.hotelcataloguemgmtservice.entities.HotelEntity;
import com.capgemini.hotelcataloguemgmtservice.entities.PicEntity;
import com.capgemini.hotelcataloguemgmtservice.util.HotelPic;

public class HotelCatalogueServiceImpl implements HotelCatalogueService {
	@Autowired
	HotelDAO hotelDAO;
	
	@Autowired
	PicDAO picDAO;
	
	@Override
	public boolean createHotel(Hotel hotel) throws HotelCreationException{
		HotelPic[] pics=hotel.getPics();
		List<PicEntity> picEntities;
		PicEntity picEntity;
		
		for(HotelPic pic:pics) {
			picEntity=new PicEntity();
			picEntity.setHotelName(hotel.getHotelName());
			picEntity.setUrl(pic.getImageUrl());
			try {
				picDAO.save(picEntity);
			}catch(Exception exception) {
				picEntities=picDAO.deleteByHotelName(hotel.getHotelName());
				System.out.println("Pics deleted from database - ");
				for(PicEntity entity:picEntities) {
					System.out.println(entity);
				}
				throw new HotelCreationException("Hotel could not be created!!!");
			}
		}
		
		HotelEntity hotelEntity=new HotelEntity();
		hotelEntity.setHotelName(hotel.getHotelName());
		hotelEntity.setLocation(hotel.getLocation());
		String[] amenities=hotel.getAmenities();
		String amenityString="";
		for(int i=0;i<amenities.length;i++)
			amenityString+=amenities[i]+" ";
		hotelEntity.setAmenities(amenityString);
		hotelEntity.setNoOfRooms(hotel.getNoOfRooms());
		hotelEntity.setPricePerRoom(hotel.getNoOfRooms());
		hotelEntity.setActiveStatus(true);
		
		try {
			hotelDAO.save(hotelEntity);
		}catch(Exception exception) {
			picEntities=picDAO.deleteByHotelName(hotel.getHotelName());
			System.out.println("Pics deleted from database - ");
			for(PicEntity entity:picEntities) {
				System.out.println(entity);
			}
			throw new HotelCreationException("Hotel could not be created!!!");
		}
		return true;
	}

	@Override
	public boolean updateHotel(Hotel hotel) throws HotelUpdationException {
		HotelEntity hotelEntity=new HotelEntity();
		hotelEntity.setHotelName(hotel.getHotelName());
		hotelEntity.setLocation(hotel.getLocation());
		String[] amenities=hotel.getAmenities();
		String amenityString="";
		for(int i=0;i<amenities.length;i++)
			amenityString+=amenities[i]+" ";
		hotelEntity.setAmenities(amenityString);
		hotelEntity.setNoOfRooms(hotel.getNoOfRooms());
		hotelEntity.setPricePerRoom(hotel.getNoOfRooms());
		
		return true;
	}

	@Override
	public boolean deleteHotel(Hotel hotel) throws HotelDeletionException{
		
		return true;
	}

}
