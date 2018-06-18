package XMLWS.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bookingws.soap.GetCategoriesRequest;
import com.bookingws.soap.GetCategoriesResponse;
import com.bookingws.soap.GetCitiesRequest;
import com.bookingws.soap.GetCitiesResponse;
import com.bookingws.soap.GetCountriesRequest;
import com.bookingws.soap.GetCountriesResponse;
import com.bookingws.soap.GetTypesAccomodationRequest;
import com.bookingws.soap.GetTypesAccomodationResponse;
import com.bookingws.soap.SetCountryRequest;
import com.bookingws.soap.SetCountryResponse;

import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.Country;
import XMLWS.model.TypeAccomodation;
import XMLWS.service.CategoryService;
import XMLWS.service.CityService;
import XMLWS.service.CountryService;
import XMLWS.service.TypeAccomodationService;


@Endpoint
public class AccomodationEndpoint {
	
	
	@Autowired
	private CountryService countryService;
	
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TypeAccomodationService typeAccomodationService;
	
	
	
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
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getCitiesRequest")
    @ResponsePayload
    public GetCitiesResponse getCitiesRequest(@RequestPayload GetCitiesRequest getCitiesRequest) {
		
		GetCitiesResponse response = new GetCitiesResponse();
		
		List<City> cities = cityService.getAll();
	
		for(City city : cities) {
			response.getCities().add(city);
		}
		
		return response;
	}
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getCategoriesRequest")
    @ResponsePayload
    public GetCategoriesResponse getCategoriesRequest(@RequestPayload GetCategoriesRequest getCategoriesRequest) {
		
		GetCategoriesResponse response = new GetCategoriesResponse();
		
		List<Category> categories= categoryService.getAllCategories();
		
		for(Category category : categories){
			response.getCategory().add(category);
		}
		
		return response;
	}
	
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getTypesAccomodationRequest")
    @ResponsePayload
    public GetTypesAccomodationResponse getTypesAccomodationRequest(@RequestPayload GetTypesAccomodationRequest getTypesAccomodationRequest) {
		
		GetTypesAccomodationResponse response = new GetTypesAccomodationResponse();
		
		List<TypeAccomodation> typesAccomodation = typeAccomodationService.getAllTypes();
		
		for(TypeAccomodation type : typesAccomodation) {
			response.getTypesAccomodation().add(type);
		}
		
		return response;
	}
	
	
	////
	
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
