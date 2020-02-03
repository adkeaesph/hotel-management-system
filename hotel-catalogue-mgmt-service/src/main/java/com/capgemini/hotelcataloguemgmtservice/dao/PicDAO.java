package com.capgemini.hotelcataloguemgmtservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.hotelcataloguemgmtservice.entities.PicEntity;

public interface PicDAO extends JpaRepository<PicEntity, Integer> {
	public List<PicEntity> deleteByHotelName(String hotelName);
}
