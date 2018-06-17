package XMLWS.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bookingws.soap.GetCountriesRequest;
import com.bookingws.soap.GetCountriesResponse;
import com.bookingws.soap.SetCountryRequest;
import com.bookingws.soap.SetCountryResponse;

import XMLWS.model.Country;
import XMLWS.service.CountryService;


@Endpoint
public class AccomodationEndpoint {
	
	
	@Autowired
	private CountryService countryService;
	
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getCountriesRequest")
    @ResponsePayload
    public GetCountriesResponse getCountriesRequest(@RequestPayload GetCountriesRequest getCountriesRequest) {
		
		GetCountriesResponse response = new GetCountriesResponse();
		
		List<Country> countries = countryService.getAll();
	
		for(Country country : countries) {
			response.getCountry().add(country);
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "setCountryRequest")
    @ResponsePayload
	public SetCountryResponse setCountryRequest(@RequestPayload SetCountryRequest request) {
		
		SetCountryResponse response = new SetCountryResponse();
		
		Country country = new Country();
		country.setName(request.getCountry().getName());
		country.setCode(request.getCountry().getCode());
		
		countryService.addCountry(country);
		
		response.setCountry(country.getName());
		
		return response;  
	} 
	
}
