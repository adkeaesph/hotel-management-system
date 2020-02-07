package com.capgemini.userprofilemgmtservice.dto;

public class StayIdListWithEmailId {
	private StayIdList stayIdList;
	private String emailId;
	
	public StayIdListWithEmailId() {
		
	}
	
	public StayIdListWithEmailId(StayIdList stayIdList, String emailId) {
		super();
		this.stayIdList = stayIdList;
		this.emailId = emailId;
	}

	public StayIdList getStayIdList() {
		return stayIdList;
	}

	public void setStayIdList(StayIdList stayIdList) {
		this.stayIdList = stayIdList;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
