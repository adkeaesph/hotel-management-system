package com.capgemini.hotelcataloguemgmtservice.dto;

import com.capgemini.hotelcataloguemgmtservice.util.HotelPic;

public class Hotel {
	private int hotelID;
	private String hotelName;
	private String location; // later to be made as a separate class, for now it is a city
	private double pricePerRoom; // No room differentiation, only one type of room
	private int noOfRooms;
	private String[] amenities;
	private HotelPic[] pics;
	
	public Hotel() {
		
	}
	
	public Hotel(String hotelName, String location, double pricePerRoom, int noOfRooms, String[] amenities,
			HotelPic[] pics) {
		super();
		this.hotelName = hotelName;
		this.location = location;
		this.pricePerRoom = pricePerRoom;
		this.noOfRooms = noOfRooms;
		this.amenities = amenities;
		this.pics = pics;
	}
	
	public Hotel(int hotelID, String hotelName, String location, double pricePerRoom, int noOfRooms, String[] amenities,
			HotelPic[] pics) {
		super();
		this.hotelID=hotelID;
		this.hotelName = hotelName;
		this.location = location;
		this.pricePerRoom = pricePerRoom;
		this.noOfRooms = noOfRooms;
		this.amenities = amenities;
		this.pics = pics;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPricePerRoom() {
		return pricePerRoom;
	}

	public void setPricePerRoom(double pricePerRoom) {
		this.pricePerRoom = pricePerRoom;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public String[] getAmenities() {
		return amenities;
	}

	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}

	public HotelPic[] getPics() {
		return pics;
	}

	public void setPics(HotelPic[] pics) {
		this.pics = pics;
	}

}
