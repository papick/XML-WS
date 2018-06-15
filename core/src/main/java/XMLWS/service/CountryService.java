package XMLWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Country;
import XMLWS.repository.CountryRepository;


@Service
public class CountryService {

	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public void addCountry(Country country) {
		
		countryRepository.save(country);
	}
	
	
	
	public List<Country> getAll() {
		
		List<Country> countries = countryRepository.findAll();
		
		return countries;
		
	}
}
