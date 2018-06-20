package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetCitiesRequest;
import com.bookingws.soap.GetCitiesResponse;

import agent.model.City;
import agent.repository.CityRepository;
import agent.resource.response.ResponseCities;
import agent.service.CityService;

@RestController
@RequestMapping(value = "/api/city")
public class CityResource {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private CityRepository cityRepository;
	

	@GetMapping("/all-cities")
	public ResponseEntity<ResponseCities> getCities() {

		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		GetCitiesRequest request = new GetCitiesRequest();
		request.setName("all");
		GetCitiesResponse response = accomodationServicePort.getCities(request);
		
		List<City> cities = response.getCities();
		
		for(City city : cities) {
			cityRepository.save(city);
		}
		
		return new ResponseEntity<>(new ResponseCities(cities), HttpStatus.OK);
	}
}
