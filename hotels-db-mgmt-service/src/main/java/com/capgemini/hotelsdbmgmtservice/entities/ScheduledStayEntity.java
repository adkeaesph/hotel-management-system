package com.capgemini.hotelsdbmgmtservice.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reservations")
public class ScheduledStayEntity {
	@Id
	@Column(name = "StayId")
	private int stayId;
	@Column(name = "HotelID")
	private int hotelID;
	@Column(name = "RoomId")
	private int roomId;
	@Column(name = "GuestName")
	private String guestName;
	@Column(name = "NoOfGuests")
	private int noOfGuests;
	@Column(name = "PhoneNo")
	private String phoneNo;
	@Column(name = "CheckinDate")
	private Date checkInDate;
	@Column(name = "CheckoutDate")
	private Date checkOutDate;

	public ScheduledStayEntity() {

	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public int getStayId() {
		return stayId;
	}

	public void setStayId(int stayId) {
		this.stayId = stayId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
