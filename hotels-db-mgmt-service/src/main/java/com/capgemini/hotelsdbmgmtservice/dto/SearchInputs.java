package com.capgemini.hotelsdbmgmtservice.dto;

import java.sql.Date;

public class SearchInputs {
	private String location;
	private Date checkInDate;
	private Date checkOutDate;
	
	public SearchInputs(String location, Date checkInDate, Date checkOutDate) {
		super();
		this.location = location;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
