package com.capgemini.userprofilemgmtservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {
	
	
	@Column(name = "USER_NAME")
	private String name;
	@Id
	@Column(name = "USER_EMAIL")
	private String mail;
	@Column(name = "USER_CONTACT")
	private String phone; 
	@Column(name = "USER_CATEGORY")
	private boolean category;
	@Column(name = "PASSWORD")
	private String password; 
	@Column(name = "USER_ACTIVE_STATUS")
	private boolean status;
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
	
	
}
