package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.dto.AccomodationSearchDTO;
import XMLWS.model.Accommodation;

@Service
public interface AccomodationService {
	
	
	public List<Accommodation> getAllAccomodations();
	public Accommodation getAccomodation(Long id);
	public List<Accommodation> getAccomodationBySearch(String cityName, int capacity);
}
