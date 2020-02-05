package com.capgemini.hotelscataloguemgmtservice.dto;

import java.util.List;

import com.capgemini.hotelscataloguemgmtservice.dto.Hotel;

public class HotelList {
	private List<Hotel> hotels;

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
}
