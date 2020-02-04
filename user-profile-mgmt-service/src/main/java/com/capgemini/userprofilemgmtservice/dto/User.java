package com.capgemini.userprofilemgmtservice.dto;



public class User {
	private String name;
	private String mail; 
	private String phone; 
	private boolean category;
	private String password;
	private boolean status;
	public User(String name, String mail, String phone, boolean category, String password, boolean status) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.category = category;
		this.password = password;
		this.status = status;
	}
	public User() {
		super();
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isCategory() {
		return category;
	}
	public void setCategory(boolean category) {
		this.category = category;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
