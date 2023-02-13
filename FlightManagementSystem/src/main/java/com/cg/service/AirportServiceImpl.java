package com.cg.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bean.Airport;
import com.cg.dao.AirportDao;
import com.cg.exception.AirportNotFoundException;


@Service("airportService")
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportDao airportDao;
	
	@Override
	public List<Airport> viewAirport() {
		return airportDao.findAll();
	}

	@Override
	public Airport viewAirport(String code) {
		Optional<Airport> a = airportDao.findById(code);
		if (a.isEmpty()) {
			
			//throw exception if no airport found
			throw new AirportNotFoundException("No airport found with code "+code);
		}
		Airport airport = a.get();
		return airport;
	}

}
