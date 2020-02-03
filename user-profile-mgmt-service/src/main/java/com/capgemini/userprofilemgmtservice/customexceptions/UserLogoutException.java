package com.capgemini.userprofilemgmtservice.customexceptions;

public class UserLogoutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 84736430978753L;
	
	public UserLogoutException(String message) {
		super(message);
	}
}

