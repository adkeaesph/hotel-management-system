package com.capgemini.hotelcataloguemgmtservice.services;

import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hotelcataloguemgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hotelcataloguemgmtservice.dto.Hotel;

public interface HotelCatalogueService {
	boolean createHotel(Hotel hotel) throws HotelCreationException;
	boolean updateHotel(Hotel hotel) throws HotelUpdationException;
	boolean deleteHotel(Hotel hotel) throws HotelDeletionException;
}
