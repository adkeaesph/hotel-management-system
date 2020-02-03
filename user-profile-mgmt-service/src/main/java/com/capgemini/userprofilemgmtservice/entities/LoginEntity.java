package com.capgemini.userprofilemgmtservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN")
public class LoginEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "USER_EMAIL")
	private String mail;
	@Column(name = "PASSWORD")
	private String password; 
	@Column(name = "USER_ACTIVE_STATUS")
	private boolean status;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
