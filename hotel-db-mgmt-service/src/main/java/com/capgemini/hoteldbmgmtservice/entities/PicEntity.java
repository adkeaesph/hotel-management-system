package com.capgemini.hoteldbmgmtservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pics")
public class PicEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PicID")
	private int id;
	@Column(name = "PicURL")
	private String url;
	@Column(name = "HotelName")
	private String hotelName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelName() {
		return hotelName;
	}
}
