package com.capgemini.hotelsdbmgmtservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hotels")
public class HotelEntity {
	@Id
	@Column(name = "HotelID")
	private int id;
	@Column(name = "HotelName")
	private String hotelName;
	@Column(name = "Location")
	private String location; // later to be made as a separate class, for now it is a city
	@Column(name = "PricePerRoom")
	private double pricePerRoom; // No room differentiation, only one type of room
	@Column(name = "NumberOfRooms")
	private int noOfRooms;
	@Column(name = "Amenities")
	private String amenities;
	@Column(name = "Active")
	private boolean activeStatus;

	public HotelEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}
