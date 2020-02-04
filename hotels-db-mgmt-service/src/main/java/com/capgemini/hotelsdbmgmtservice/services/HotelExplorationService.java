package com.capgemini.hotelsdbmgmtservice.services;

import java.util.List;

import com.capgemini.hotelsdbmgmtservice.dto.Hotel;
import com.capgemini.hotelsdbmgmtservice.dto.SearchInputs;

public interface HotelExplorationService {
	List<Hotel> searchSimple(SearchInputs inputs);
	
}
