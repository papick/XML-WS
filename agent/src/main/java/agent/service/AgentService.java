package agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetAdditionsRequest;
import com.bookingws.soap.GetAdditionsResponse;
import com.bookingws.soap.GetAgentRequest;
import com.bookingws.soap.GetAgentResponse;
import com.bookingws.soap.GetCategoriesRequest;
import com.bookingws.soap.GetCategoriesResponse;
import com.bookingws.soap.GetCitiesRequest;
import com.bookingws.soap.GetCitiesResponse;
import com.bookingws.soap.GetCountriesRequest;
import com.bookingws.soap.GetCountriesResponse;
import com.bookingws.soap.GetMessagesForAgentRequest;
import com.bookingws.soap.GetMessagesForAgentResponse;
import com.bookingws.soap.GetReservationsForAgentRequest;
import com.bookingws.soap.GetReservationsForAgentResponse;
import com.bookingws.soap.GetTypesAccomodationRequest;
import com.bookingws.soap.GetTypesAccomodationResponse;

import agent.model.Accommodation;
import agent.model.Addition;
import agent.model.Agent;
import agent.model.Category;
import agent.model.City;
import agent.model.Country;
import agent.model.Message;
import agent.model.Period;
import agent.model.Reservation;
import agent.model.TypeAccomodation;
import agent.model.User;
import agent.repository.AccomodationRepository;
import agent.repository.AditionalServiceRepository;
import agent.repository.AgentRepository;
import agent.repository.CategoryRepository;
import agent.repository.CityRepository;
import agent.repository.CountryRepository;
import agent.repository.MessageRepository;
import agent.repository.PeriodRepository;
import agent.repository.ReservationRepository;
import agent.repository.TypeAccomodationRepository;
import agent.repository.UserRepository;
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
		
	@Autowired 
	private UserRepository userRepository;
		
	@Autowired
	private AccomodationRepository accomodationRepository;
	
	@Autowired
	private PeriodRepository periodRepository;
	
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@Autowired
	private MessageRepository messageRepository;
	
	

	public Agent logIn(AgentDTO agentDTO) {

		Agent agent = agentRepository.findOneByUsername(agentDTO.getUsername());
		if (agent == null) {
			throw new IllegalArgumentException("Agent not found!");
		}

		if (agent.getPassword().equals(agentDTO.getPassword())) {
					
			
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
		request6.setUsername(username);
		GetReservationsForAgentResponse response6 = accomodationServicePort.getReservationsForAgent(request6);
		
		List<Reservation> reservations = response6.getReservations();
		
		
		if(reservations != null) {
			
			for(Reservation res : reservations) {
				
	
				Reservation reservation = new Reservation();
				
				User user = userRepository.findByUsername(res.getUser().getUsername());
				
				if(user == null) {
					
					User us = new User();
					us.setUsername(res.getUser().getUsername());
					us.setPassword(res.getUser().getPassword());
					us.setEmail(res.getUser().getEmail());
					us.setType(res.getUser().getType());
					
					userRepository.save(us);
					reservation.setUser(us);					
				}				
				else{					
					reservation.setUser(user);
				}
								
				Period period = res.getPeriod();
				
				Period per = new Period();
				
				per.setFromDate(period.getFromDate());
				per.setToDate(period.getToDate());
				
				Accommodation accommodation = accomodationRepository.findOne(period.getAccomodation().getIdAgentApp());
				per.setAccomodation(accommodation);
				
				periodRepository.save(period);
				
				reservation.setPeriod(per);
				reservation.setConfirmed(false);
				
				reservationRepository.save(reservation);
				
			}
		}
		
		
		
		
		
		// messages
		
		GetMessagesForAgentRequest request7 = new GetMessagesForAgentRequest();
		request7.setUsername(username);
		GetMessagesForAgentResponse response7 = accomodationServicePort.getMessagesForAgent(request7);
		
		
		
		
		
		List<Message> messages = response7.getMessages();
		
		if(messages != null) {
			
			for(Message message : messages) {
				
				Message mes = new Message();
				
				User user = userRepository.findByUsername(mes.getSender().getUsername());
				Agent agent = agentRepository.findOneByUsername(mes.getRecipient().getUsername());
				
				mes.setIdCore(message.getId());
				mes.setText(message.getText());
				mes.setSender(user);
				mes.setRecipient(agent);
				
				messageRepository.save(mes);
				
			}
		}
		
		// to do
		
	}
	
	
	public Long checkIdAgent(String username) {
		
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		GetAgentRequest request = new GetAgentRequest();
		request.setUsername(username);
		GetAgentResponse response = accomodationServicePort.getAgent(request);
		
		Long id = response.getAgent().getId();
		
		return id;
	}
	
	
}
