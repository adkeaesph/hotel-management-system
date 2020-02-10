package com.capgemini.userprofilemgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.userprofilemgmtservice.entities.StayEntity;

public interface StayDAO extends JpaRepository<StayEntity, Integer> {
	
}
