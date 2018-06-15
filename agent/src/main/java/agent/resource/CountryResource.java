package agent.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetCountriesRequest;
import com.bookingws.soap.GetCountriesResponse;

import agent.model.Country;

@RestController
@RequestMapping(value = "/api/country")
public class CountryResource {
	

	@RequestMapping(method = RequestMethod.GET,
            value = "/get-countries",
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> getCountries() {
		
		Country country = new Country();
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		GetCountriesRequest request = new GetCountriesRequest();
		request.setName("all");;
		GetCountriesResponse response = accomodationServicePort.getCountries(request);
		List<Country> countries = response.getCountry();
		
		
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

}
