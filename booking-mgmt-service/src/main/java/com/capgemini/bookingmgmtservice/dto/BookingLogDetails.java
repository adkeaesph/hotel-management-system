package com.capgemini.bookingmgmtservice.dto;

import java.util.List;

public class BookingLogDetails {
	private List<Reservation> reservations;
	private String emailId;
	
	public BookingLogDetails() {
		
	}
	
	public BookingLogDetails(List<Reservation> reservations, String emailId) {
		super();
		this.reservations = reservations;
		this.emailId = emailId;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
