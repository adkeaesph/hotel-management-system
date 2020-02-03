package com.capgemini.hotelcataloguemgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hotelcataloguemgmtservice.entities.PicEntity;

public interface PicDAO extends JpaRepository<PicEntity, Integer> {
	PicEntity[] deleteByHotelName(String hotelName);
	PicEntity[] findByHotelName(String hotelName);
}
