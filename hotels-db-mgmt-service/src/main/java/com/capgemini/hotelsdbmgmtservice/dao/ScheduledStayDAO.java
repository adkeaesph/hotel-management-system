package com.capgemini.hotelsdbmgmtservice.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelsdbmgmtservice.entities.ScheduledStayEntity;

@Repository
public interface ScheduledStayDAO extends JpaRepository<ScheduledStayEntity, Integer> {
	@Query(value = "SELECT * FROM Reservations WHERE HotelID=?1 AND (CheckinDate<=?2 OR CheckoutDate>=?3)", nativeQuery = true)
	List<ScheduledStayEntity> findOccupiedRooms(int hotelID, Date checkIn, Date checkOut);
}
