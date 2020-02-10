package com.capgemini.userprofilemgmtservice.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userprofilemgmtservice.customexceptions.AddBookingLogException;
import com.capgemini.userprofilemgmtservice.dao.StayDAO;
import com.capgemini.userprofilemgmtservice.dao.UserBookingDAO;
import com.capgemini.userprofilemgmtservice.dto.StayIdListWithEmailId;
import com.capgemini.userprofilemgmtservice.entities.StayEntity;
import com.capgemini.userprofilemgmtservice.entities.UserBookingEntity;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserBookingDAO userBookingDAO;
	
	@Autowired
	StayDAO stayDAO;
	
	@Override
	public boolean addBookingLog(StayIdListWithEmailId stayIdListWithEmailId) throws AddBookingLogException {
		try {
			String emailID=stayIdListWithEmailId.getEmailId();
			int rows=(int)userBookingDAO.count();
			UserBookingEntity userBookingEntity=new UserBookingEntity();
			userBookingEntity.setBookingID(rows+1);
			userBookingEntity.setEmailID(emailID);
			userBookingEntity.setBookingDate(new Date(System.currentTimeMillis()));
			userBookingEntity.setStatus("Booked");
			userBookingDAO.save(userBookingEntity);
			
			List<Integer> stayIds=stayIdListWithEmailId.getStayIdList().getStayIds();
			StayEntity stayEntity;
			for(Integer stayID:stayIds) {
				stayEntity=new StayEntity();
				stayEntity.setBookingID(rows+1);
				stayEntity.setStayID(stayID);
				stayDAO.save(stayEntity);
			}
		}catch(Exception exception) {
			throw new AddBookingLogException("Booking log could not be added!!!");
		}
		return true;
	}

}
