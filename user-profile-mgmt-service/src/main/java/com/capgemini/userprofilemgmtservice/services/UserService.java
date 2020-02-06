package com.capgemini.userprofilemgmtservice.services;

import com.capgemini.userprofilemgmtservice.customexceptions.UserLoginException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserLogoutException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserRegisterException;
import com.capgemini.userprofilemgmtservice.dto.User;
import com.capgemini.userprofilemgmtservice.entities.UserEntity;

public interface UserService {
	UserEntity login(User user) throws UserLoginException;
	boolean register(User user) throws Exception;
	boolean logout(User user) throws UserLogoutException;
}
