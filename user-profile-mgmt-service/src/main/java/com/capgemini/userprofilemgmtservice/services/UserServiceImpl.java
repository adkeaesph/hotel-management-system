package com.capgemini.userprofilemgmtservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userprofilemgmtservice.customexceptions.UserLoginException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserLogoutException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserRegisterException;
import com.capgemini.userprofilemgmtservice.dao.UserDAO;
import com.capgemini.userprofilemgmtservice.dto.User;
import com.capgemini.userprofilemgmtservice.entities.UserEntity;
import com.capgemini.userprofilemgmtservice.util.Authenticator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public boolean register(User user) throws Exception {

		/*
		 * System.out.println("1"); List<User> listUser =
		 * userDAO.findByUsers(user.getMail()); if (listUser.isEmpty()) { throw new
		 * UserRegisterException(UserRegisterException.USER_EXISTS); }
		 * 
		 * else {
		 */

		UserEntity userEntity = new UserEntity();

		userEntity.setName(user.getName());
		userEntity.setMail(user.getMail());
		userEntity.setPhone(user.getPhone());
		userEntity.setCategory(user.isCategory());
		userEntity.setPassword(Authenticator.encrypt(user.getPassword(), "NIRMAAN"));
		userEntity.setStatus(false);
		try {
			userDAO.save(userEntity);
		} catch (Exception exception) {
			throw new UserRegisterException(exception.getMessage());
		}
		return true;
	}

	@Override
	public boolean login(User user) throws UserLoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout(User user) throws UserLogoutException {
		// TODO Auto-generated method stub
		return false;
	}
}