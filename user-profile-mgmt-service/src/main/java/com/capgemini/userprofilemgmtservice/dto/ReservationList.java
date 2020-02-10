package com.capgemini.userprofilemgmtservice.dto;

import java.util.List;

public class ReservationList {
	private List<Reservation> reservations;

	public ReservationList() {
		
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
