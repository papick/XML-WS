package agent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.City;
import agent.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public ArrayList<City> getAllCities() {
		return (ArrayList<City>) cityRepository.findAll();
	}

}
