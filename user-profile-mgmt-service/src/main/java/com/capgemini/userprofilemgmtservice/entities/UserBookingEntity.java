package com.capgemini.userprofilemgmtservice.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_BOOKINGS")
public class UserBookingEntity {
	@Id
	@Column(name = "BookingID")
	private int BookingID;
	
	@Column(name = "EmailID")
	private String emailID;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "BookingDate")
	private Date BookingDate;

	public UserBookingEntity() {
		
	}
	
	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	
}
