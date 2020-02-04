package com.capgemini.userprofilemgmtservice.services;

import com.capgemini.userprofilemgmtservice.customexceptions.UserLoginException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserLogoutException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserRegisterException;
import com.capgemini.userprofilemgmtservice.dto.User;

public interface UserService {
	boolean login(User user) throws UserLoginException;
	boolean register(User user) throws Exception;
	boolean logout(User user) throws UserLogoutException;
}
