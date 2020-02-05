package com.capgemini.hotelsdbmgmtservice.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reservations")
public class ScheduleStayEntity {
	@Id
	@Column(name = "StayId")
	private int stayId;
	@Column(name = "HotelID")
	private int hotelID;
	@Column(name = "RoomId")
	private int roomId;
	@Column(name = "GuestName")
	private String gName;
	@Column(name = "NoOfGuests")
	private int noOfGuests;
	@Column(name = "PhoneNo")
	private int phoneNo;
	@Column(name = "CheckinDate")
	private Date checkInDate;
	@Column(name = "CheckoutDate")
	private Date checkOutDate;

	public ScheduleStayEntity() {

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

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
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
