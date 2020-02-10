package com.capgemini.userprofilemgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.userprofilemgmtservice.entities.UserBookingEntity;

public interface UserBookingDAO extends JpaRepository<UserBookingEntity, Integer> {

}
