package com.capgemini.userprofilemgmtservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAYS")
public class StayEntity {
	@Id
	@Column(name = "StayID")
	private int stayID;
	
	@Column(name = "BookingID")
	private int bookingID;
	
	public StayEntity() {
		
	}

	public int getStayID() {
		return stayID;
	}

	public void setStayID(int stayID) {
		this.stayID = stayID;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	
}
