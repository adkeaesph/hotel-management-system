package com.capgemini.hotelexplorationservice.dto;

public class Hotel {
	private int hotelID;
	private String hotelName;
	private String location; // later to be made as a separate class, for now it is a city
	private double pricePerRoom; // No room differentiation, only one type of room
	private int noOfRooms;
	private int roomsAvailable;
	private String amenities;

	public Hotel() {
		
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

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public int getRoomsAvailable() {
		return roomsAvailable;
	}

	public void setRoomsAvailable(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

	@Override
	public String toString() {
		return "Hotel [hotelID=" + hotelID + ", hotelName=" + hotelName + ", location=" + location + ", pricePerRoom="
				+ pricePerRoom + ", noOfRooms=" + noOfRooms + ", roomsAvailable=" + roomsAvailable + ", amenities="
				+ amenities + "]";
	}
}
