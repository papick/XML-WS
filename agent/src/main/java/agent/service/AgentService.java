package agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetAdditionsRequest;
import com.bookingws.soap.GetAdditionsResponse;
import com.bookingws.soap.GetCategoriesRequest;
import com.bookingws.soap.GetCategoriesResponse;
import com.bookingws.soap.GetCitiesRequest;
import com.bookingws.soap.GetCitiesResponse;
import com.bookingws.soap.GetCountriesRequest;
import com.bookingws.soap.GetCountriesResponse;
import com.bookingws.soap.GetReservationsForAgentRequest;
import com.bookingws.soap.GetTypesAccomodationRequest;
import com.bookingws.soap.GetTypesAccomodationResponse;

import agent.model.Addition;
import agent.model.Agent;
import agent.model.Category;
import agent.model.City;
import agent.model.Country;
import agent.model.TypeAccomodation;
import agent.repository.AditionalServiceRepository;
import agent.repository.AgentRepository;
import agent.repository.CategoryRepository;
import agent.repository.CityRepository;
import agent.repository.CountryRepository;
import agent.repository.TypeAccomodationRepository;
import agent.service.dto.AgentDTO;

@Transactional
@Service
public class AgentService {
	
	
	@Autowired 
	private CountryRepository countryRepository;
	
	@Autowired 
	private CityRepository cityRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private AditionalServiceRepository aditionalServiceRepository;
	
	@Autowired 
	private TypeAccomodationRepository typeAccomodationRepository;
	

	@Autowired
	private AgentRepository agentRepository;

	public Agent logIn(AgentDTO agentDTO) {

		Agent agent = agentRepository.findOneByUsername(agentDTO.getUsername());
		if (agent == null) {
			throw new IllegalArgumentException("Agent not found!");
		}

		if (agent.getPassword().equals(agentDTO.getPassword())) {
					
			System.out.println("PROSAOXXXX");
			synchronizeDB(agent.getUsername());
			
			return agent;
		}

		return null;
	}
	
	
	public void synchronizeDB(String username) {
		
		System.out.println("PROLAZIII");
		
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		
		//countries
		
		GetCountriesRequest request = new GetCountriesRequest();
		request.setName("all");;
		GetCountriesResponse response = accomodationServicePort.getCountries(request);
		List<Country> countries = response.getCountry();
		
		for(Country c : countries) {
			countryRepository.save(c);
		}
		
		
		// cities
		
		
		GetCitiesRequest request2 = new GetCitiesRequest();
		request.setName("all");
		GetCitiesResponse response2= accomodationServicePort.getCities(request2);
		
		List<City> cities = response2.getCities();
		
		for(City city : cities) {
			cityRepository.save(city);
		}
		
		
		// types
		
		GetTypesAccomodationRequest request3 = new GetTypesAccomodationRequest();
		request.setName("all");;
		GetTypesAccomodationResponse response3 = accomodationServicePort.getTypesAccomodation(request3);
		List<TypeAccomodation> types = response3.getTypesAccomodation();
		
		
		for(TypeAccomodation type : types) {
			typeAccomodationRepository.save(type);
		}
		
		// categories
		
		
		GetCategoriesRequest request4 = new GetCategoriesRequest();
		request.setName("all");
		GetCategoriesResponse response4 = accomodationServicePort.getCategories(request4);
		List<Category> categories = response4.getCategory();
		
		for(Category c : categories) {
			categoryRepository.save(c);
		}
		
		// aditions
		
		
		GetAdditionsRequest request5 = new GetAdditionsRequest();
		request.setName("all");
		GetAdditionsResponse response5 = accomodationServicePort.getAdditions(request5);
		
		List<Addition> services = response5.getAdditions();

		for(Addition addition : services) {
			aditionalServiceRepository.save(addition);
		}
		
		
		
		// reservations
		
		GetReservationsForAgentRequest request6 = new GetReservationsForAgentRequest();
		
		/*
		Agent agent
		
		request6.setId(value); */
		
		
		// messages
		
		
		
	}
	
	
}
