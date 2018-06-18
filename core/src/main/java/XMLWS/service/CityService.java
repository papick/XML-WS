package XMLWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.City;
import XMLWS.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;
	
	public List<City> getAll() {
		
		List<City> cities = cityRepository.findAll();
		
		return cities;
	}
}
