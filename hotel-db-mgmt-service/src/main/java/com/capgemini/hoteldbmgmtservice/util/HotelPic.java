package com.capgemini.hoteldbmgmtservice.util;

public class HotelPic {
	private String imageUrl;

	public HotelPic() {
		
	}
	
	public HotelPic(String imageUrl) {
		this();
		this.imageUrl=imageUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
