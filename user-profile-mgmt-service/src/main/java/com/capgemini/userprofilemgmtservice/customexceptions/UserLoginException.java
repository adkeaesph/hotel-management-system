package com.capgemini.userprofilemgmtservice.customexceptions;

public class UserLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8473643678753L;
	
	public UserLoginException(String message) {
		super(message);
	}
}