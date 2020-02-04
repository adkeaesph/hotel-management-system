package com.capgemini.hoteldbmgmtservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hoteldbmgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hoteldbmgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hoteldbmgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hoteldbmgmtservice.dao.PicDAO;
import com.capgemini.hoteldbmgmtservice.dao.WriteHotelDAO;
import com.capgemini.hoteldbmgmtservice.dto.Hotel;
import com.capgemini.hoteldbmgmtservice.entities.HotelEntity;
import com.capgemini.hoteldbmgmtservice.entities.PicEntity;
import com.capgemini.hoteldbmgmtservice.util.HotelPic;

@Service
public class HotelCatalogueServiceImpl implements HotelCatalogueService {
	@Autowired
	WriteHotelDAO writeHotelDAO;

	@Autowired
	PicDAO picDAO;

	@Override
	public boolean createHotel(Hotel hotel) throws HotelCreationException {
		HotelPic[] pics = hotel.getPics();
		PicEntity[] picEntities;
		PicEntity picEntity;

		for (HotelPic pic : pics) {
			picEntity = new PicEntity();
			picEntity.setHotelName(hotel.getHotelName());
			picEntity.setUrl(pic.getImageUrl());
			try {
				picDAO.save(picEntity);
			} catch (Exception exception) {
				picEntities = picDAO.deleteByHotelName(hotel.getHotelName());
				System.out.println("Pics deleted from database - ");
				for (PicEntity entity : picEntities) {
					System.out.println(entity);
				}
				throw new HotelCreationException("Hotel could not be created!!!");
			}
		}

		HotelEntity hotelEntity = new HotelEntity();
		hotelEntity.setHotelName(hotel.getHotelName());
		hotelEntity.setLocation(hotel.getLocation());
		String[] amenities = hotel.getAmenities();
		String amenityString = "";
		for (int i = 0; i < amenities.length; i++)
			amenityString += amenities[i] + " ";
		hotelEntity.setAmenities(amenityString);
		hotelEntity.setNoOfRooms(hotel.getNoOfRooms());
		hotelEntity.setPricePerRoom(hotel.getNoOfRooms());
		hotelEntity.setActiveStatus(true);

		try {
			writeHotelDAO.save(hotelEntity);
		} catch (Exception exception) {
			picEntities = picDAO.deleteByHotelName(hotel.getHotelName());
			System.out.println("Pics deleted from database - ");
			for (PicEntity entity : picEntities) {
				System.out.println(entity);
			}
			throw new HotelCreationException("Hotel could not be created!!!");
		}
		return true;
	}

	@Override
	public boolean updateHotel(Hotel hotel) throws HotelUpdationException {
		HotelEntity hotelEntity = writeHotelDAO.findByHotelID(hotel.getHotelID());

		if (hotel.getHotelName() != null) {
			String hotelName=hotel.getHotelName();
			hotelEntity.setHotelName(hotelName);
			PicEntity[] picEntities = picDAO.findByHotelName(hotelName);
			for(int i=0;i<picEntities.length;i++) {
				picEntities[i].setHotelName(hotelName);
				picDAO.save(picEntities[i]);
			}
		}
		if (hotel.getLocation() != null)
			hotelEntity.setLocation(hotel.getLocation());
		if (hotel.getAmenities() != null) {
			String[] amenities = hotel.getAmenities();
			String amenityString = "";
			for (int i = 0; i < amenities.length; i++)
				amenityString += amenities[i] + " ";

			hotelEntity.setAmenities(hotelEntity.getAmenities() + amenityString);
		}

		if (hotel.getPics() != null) {
			HotelPic[] pics = hotel.getPics();
			PicEntity picEntity;
			for (int i = 0; i < pics.length; i++) {
				picEntity = new PicEntity();
				picEntity.setHotelName(hotelEntity.getHotelName());
				picEntity.setUrl(pics[i].getImageUrl());
				picDAO.save(picEntity);
			}

		}

		if (hotel.getNoOfRooms() != 0)
			hotelEntity.setNoOfRooms(hotel.getNoOfRooms());
		if (hotel.getPricePerRoom() != 0)
			hotelEntity.setPricePerRoom(hotel.getPricePerRoom());

		try {
			writeHotelDAO.save(hotelEntity);
		} catch (Exception exception) {
			throw new HotelUpdationException("Hotel could not be updated!!!");
		}

		return true;
	}

	@Override
	public boolean deleteHotel(Hotel hotel) throws HotelDeletionException {
		HotelEntity hotelEntity = writeHotelDAO.findByHotelID(hotel.getHotelID());
		hotelEntity.setActiveStatus(false);
		try {
			writeHotelDAO.save(hotelEntity);
		}catch(Exception exception) {
			throw new HotelDeletionException("Hotel could not be deleted!!!");
		}
		return true;
	}

}
