package com.capgemini.hoteldbmgmtservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.hoteldbmgmtservice.entities.HotelEntity;

@Repository
public interface WriteHotelDAO extends JpaRepository<HotelEntity, Integer> {
	HotelEntity findByHotelID(int hotelID);
}
