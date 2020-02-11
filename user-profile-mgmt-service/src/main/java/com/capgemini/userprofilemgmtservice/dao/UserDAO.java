package com.capgemini.userprofilemgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.userprofilemgmtservice.entities.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, String> {
//	List<User> findByUsers(String emailAddress);

}
