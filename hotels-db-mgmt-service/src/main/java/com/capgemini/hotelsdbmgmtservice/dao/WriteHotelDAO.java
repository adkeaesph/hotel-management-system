package com.capgemini.hotelsdbmgmtservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelsdbmgmtservice.entities.HotelEntity;

@Repository
public interface WriteHotelDAO extends JpaRepository<HotelEntity, Integer> {
	List<HotelEntity> findByLocation(String location);
}
