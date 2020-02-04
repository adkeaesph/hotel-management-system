package com.capgemini.hotelsdbmgmtservice.dao;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelsdbmgmtservice.entities.HotelEntity;
import com.capgemini.hotelsdbmgmtservice.entities.ScheduleStayEntity;

@Repository
public interface ScheduleStayDAO extends JpaRepository<ScheduleStayEntity, Integer> {
	@Query(value="SELECT * FROM ScheduledStay WHERE HotelName=?1 AND (CheckinDate<=?2 OR CheckoutDate>=?3)",nativeQuery=true)
	List<ScheduleStayEntity> findOccupiedRooms(String hotelName,Date checkIn,Date checkOut);

}
