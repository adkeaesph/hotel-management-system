package com.capgemini.hotelsdbmgmtservice.dto;

import java.sql.Date;

public class SearchInputs {
	private String location;
	private Date checkInDate;
	private Date checkOutDate;
	

	private double minPrice;
	private double maxPrice;
	
	public SearchInputs(String location, Date checkInDate, Date checkOutDate, double minPrice, double maxPrice) {
		super();
		this.location = location;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		
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
	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

}
