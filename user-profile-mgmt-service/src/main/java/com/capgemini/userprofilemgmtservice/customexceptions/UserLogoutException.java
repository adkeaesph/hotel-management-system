package com.capgemini.userprofilemgmtservice.customexceptions;

public class UserLogoutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 84736430978753L;
	
	public UserLogoutException(String message) {
		super(message);
	}
	public static final String USER_NOT_EXISTS = " User with the given user id doesn't exists";
	public static final String USER_LOGOUT_ERROR = " User logged out succesfully";
}

