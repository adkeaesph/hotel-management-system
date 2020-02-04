package com.capgemini.hotelsdbmgmtservice.services;

import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelCreationException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelDeletionException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelReAdditionException;
import com.capgemini.hotelsdbmgmtservice.customexceptions.HotelUpdationException;
import com.capgemini.hotelsdbmgmtservice.dto.Hotel;

public interface HotelCatalogueService {
	boolean createHotel(Hotel hotel) throws HotelCreationException;
	boolean updateHotel(Hotel hotel) throws HotelUpdationException;
	boolean deleteHotel(Hotel hotel) throws HotelDeletionException;
	boolean reAddHotel(Hotel hotel) throws HotelReAdditionException;

}
