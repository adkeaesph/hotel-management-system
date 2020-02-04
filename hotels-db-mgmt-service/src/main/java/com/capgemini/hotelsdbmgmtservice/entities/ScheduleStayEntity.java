package com.capgemini.hotelsdbmgmtservice.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
//@NamedNativeQuery(name="ScheduleStay.occupiedRooms", query ="SELECT COUNT(*) FROM ScheduledStay WHERE HotelName=? AND (CheckinDate>? OR CheckoutDate<?);")
@Table(name = "ScheduledStay")

public class ScheduleStayEntity {
	
	@Id
	@Column(name = "HotelName")
	private String hName;
	@Column(name = "StayId")
	private int stayId;
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
	
	public String getHname() {
		return hName;
	}
	public void setHname(String hname) {
		this.hName = hname;
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
