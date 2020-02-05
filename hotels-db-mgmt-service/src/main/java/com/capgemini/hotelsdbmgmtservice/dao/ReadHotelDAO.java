package com.capgemini.hotelsdbmgmtservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelsdbmgmtservice.entities.HotelEntity;
@Repository
public interface ReadHotelDAO extends JpaRepository<HotelEntity, Integer>{
	List<HotelEntity> findByLocation(String location);
	
	@Query(value = "SELECT * FROM Hotels WHERE Location=?1 AND (PricePerRoom>=?2 AND PricePerRoom<=?3)", nativeQuery = true)
	List<HotelEntity> findByLocation(String location, double minPrice, double maxPrice);

}
