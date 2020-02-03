package com.capgemini.hoteldbmgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.hoteldbmgmtservice.entities.PicEntity;

@Repository
public interface PicDAO extends JpaRepository<PicEntity, Integer> {
	PicEntity[] deleteByHotelName(String hotelName);
	PicEntity[] findByHotelName(String hotelName);
}
