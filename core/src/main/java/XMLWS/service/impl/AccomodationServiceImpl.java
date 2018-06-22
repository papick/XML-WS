package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Accommodation;
import XMLWS.repository.AccomodationRepository;
import XMLWS.service.AccomodationService;

@Service
public class AccomodationServiceImpl implements AccomodationService {

	@Autowired 
	private AccomodationRepository accomodationRepository;
		
	@Override
	public List<Accommodation> getAllAccomodations() {
		return accomodationRepository.findAll();
	}

	@Override
	public Accommodation getAccomodation(Long id) {
		return accomodationRepository.findOne(id);
	}

	@Override
	public List<Accommodation> getAccomodationBySearch(String cityName , int capacity) {
		
		return accomodationRepository.findByCityNameIgnoreCaseContainingAndCapacity(cityName, capacity) ;
	}
		

}
