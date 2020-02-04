package com.capgemini.userprofilemgmtservice.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	@Autowired
	private SessionFactory sessionFactory;
	// this will create one sessionFactory for this class
	// there is only one sessionFactory should be created for the applications
	// we can create multiple sessions for a sessionFactory
	// each session can do some functions

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
		boolean userLoginStatus = false;
		Session session = null;
		Transaction transaction = null;
		UserEntity existingUser = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			existingUser = session.find(UserEntity.class, user.getMail());
			if (existingUser == null) {
				throw new UserLoginException(UserLoginException.USER_NOT_EXISTS);
			}
			if (existingUser.isStatus() == true) {
				throw new UserLoginException(UserLoginException.ALREADY_LOGGEDIN);
			}
			if (Authenticator.encrypt(user.getPassword(), "NIRMAAN").equals(existingUser.getPassword())) {
				existingUser.setStatus(true);
				transaction.commit();
				userLoginStatus = true;
			}

			else {
				throw new UserLoginException(UserLoginException.PASSWORD_MISMATCH);
			}
		} catch (Exception exp) {
			transaction.rollback();
			throw new UserLoginException(UserLoginException.USER_LOGIN_ERROR + exp.getMessage());
		} finally {

			session.close();
		}

		return userLoginStatus;

	}

	@Override
	public boolean logout(User user) throws UserLogoutException {
		boolean userLogoutStatus = false;
		Session session = null;
		Transaction transaction = null;
		UserEntity existingUser = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			existingUser = session.find(UserEntity.class, user.getMail());
			if (existingUser == null) {
				throw new UserLogoutException(UserLogoutException.USER_NOT_EXISTS);
			}
			existingUser.setStatus(false);
			transaction.commit();
			userLogoutStatus = true;
		} catch (Exception exp) {
			transaction.rollback();
			throw new UserLogoutException(UserLogoutException.USER_LOGOUT_ERROR + exp.getMessage());
		} finally {

			session.close();
		}

		return userLogoutStatus;
	}
}
