package com.capgemini.userprofilemgmtservice.customexceptions;

public class UserRegisterException extends Exception {


	public UserRegisterException(String message) {
		super(message);
	}
	private static final long serialVersionUID = -8852205511678760596L;
	public static final String USER_EXISTS = " User with the given E-mail already exists";
	public static final String USER_REG_ERROR = " Error in registering a new User >>>";
	
	

}
