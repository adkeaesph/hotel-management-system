package com.capgemini.userprofilemgmtservice.dto;

import java.sql.Date;

public class Reservation {
	private int hotelID;
	private String guestName;
	private int noOfGuests;
	private String phoneNo;
	private Date checkinDate;
	private Date checkoutDate;

	public Reservation() {
		
	}
	
	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
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

	public void setPhoneNo(String phone) {
		this.phoneNo = phone;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

}
