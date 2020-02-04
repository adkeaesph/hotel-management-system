package com.capgemini.userprofilemgmtservice.customexceptions;

public class UserLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8473643678753L;
	
	public UserLoginException(String message) {
		super(message);
	}
	
	public static final String USER_NOT_EXISTS = " User with the given user id doesn't exists";
	public static final String ALREADY_LOGGEDIN = " User Already Logged in ! Please log out first";
	public static final String PASSWORD_MISMATCH = " Username or Password is incorrect";
	public static final String USER_LOGIN_ERROR = " Error in logging in >>>";
}