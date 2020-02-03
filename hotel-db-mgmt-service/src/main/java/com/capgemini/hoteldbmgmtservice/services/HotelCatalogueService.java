package com.capgemini.hoteldbmgmtservice.services;

import com.capgemini.hoteldbmgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hoteldbmgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hoteldbmgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hoteldbmgmtservice.dto.Hotel;

public interface HotelCatalogueService {
	boolean createHotel(Hotel hotel) throws HotelCreationException;
	boolean updateHotel(Hotel hotel) throws HotelUpdationException;
	boolean deleteHotel(Hotel hotel) throws HotelDeletionException;
}
