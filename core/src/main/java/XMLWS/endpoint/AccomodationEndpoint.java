package XMLWS.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bookingws.soap.AddAccomodationRequest;
import com.bookingws.soap.AddAccomodationResponse;
import com.bookingws.soap.AddPeriodRequest;
import com.bookingws.soap.AddPeriodResponse;
import com.bookingws.soap.GetAdditionsRequest;
import com.bookingws.soap.GetAdditionsResponse;
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
import com.bookingws.soap.SendResponseRequest;
import com.bookingws.soap.SendResponseResponse;
import com.bookingws.soap.SetCountryRequest;
import com.bookingws.soap.SetCountryResponse;
import com.bookingws.soap.SetPricesRequest;
import com.bookingws.soap.SetPricesRespone;

import XMLWS.model.Accommodation;
import XMLWS.model.Addition;
import XMLWS.model.Agent;
import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.Country;
import XMLWS.model.MessageAgent;
import XMLWS.model.Period;
import XMLWS.model.Price;
import XMLWS.model.ReservationAgent;
import XMLWS.model.Response;
import XMLWS.model.TypeAccomodation;
import XMLWS.repository.AccomodationRepository;
import XMLWS.repository.AgentRepository;
import XMLWS.repository.MessageAgentRepository;
import XMLWS.repository.PeriodRepository;
import XMLWS.repository.PriceRepository;
import XMLWS.repository.ReservationAgentRepository;
import XMLWS.repository.ResponseRepository;
import XMLWS.service.AdditionalServiceService;
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
	
	
	@Autowired
	private AccomodationRepository accomodationRepository;
	
	@Autowired
	private PeriodRepository periodRepository;
	
	@Autowired
	private AdditionalServiceService additionalServiceService;
	
	@Autowired
	private PriceRepository priceRepository;
	
	
	@Autowired
	private AgentRepository agentRepository;
	
	
	@Autowired
	private MessageAgentRepository messageAgentRepository;
	
	
	@Autowired
	private ReservationAgentRepository reservationAgentRepository;
	
	
	@Autowired
	private ResponseRepository responseRepository;
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getCountriesRequest")
    @ResponsePayload
    public GetCountriesResponse getCountriesRequest(@RequestPayload GetCountriesRequest getCountriesRequest) {
		
		GetCountriesResponse response = new GetCountriesResponse();
		
		List<Country> countries = countryService.getAll();
	
		for(Country country : countries) {
			response.getCountry().add(country);
			System.out.println(country.getName());
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
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getAdditionsRequest")
    @ResponsePayload
    public GetAdditionsResponse getAdditionsRequest(@RequestPayload GetAdditionsRequest getAdditionsRequest) {
		
		GetAdditionsResponse response = new GetAdditionsResponse();
		
		List<Addition> additions = additionalServiceService.getAllServices();
		
		for(Addition addition : additions) {
			response.getAdditions().add(addition);
		}
		
		return response;
	}
	
	
	
	
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "addAccomodationRequest")
    @ResponsePayload
    public AddAccomodationResponse addAccomodationRequest(@RequestPayload AddAccomodationRequest addAccomodationRequest) {
		
		AddAccomodationResponse response = new AddAccomodationResponse();
		
		Accommodation accommodation = new Accommodation();
		accommodation.setIdAgentApp(addAccomodationRequest.getAccomodation().getId());
		accommodation.setAdditions(addAccomodationRequest.getAccomodation().getAdditions());
		accommodation.setAddress(addAccomodationRequest.getAccomodation().getAddress());
		accommodation.setAgent(addAccomodationRequest.getAccomodation().getAgent());
		accommodation.setCapacity(addAccomodationRequest.getAccomodation().getCapacity());
		accommodation.setCategory(addAccomodationRequest.getAccomodation().getCategory());
		accommodation.setCity(addAccomodationRequest.getAccomodation().getCity());
		accommodation.setDescription(addAccomodationRequest.getAccomodation().getDescription());
		accommodation.setImage(addAccomodationRequest.getAccomodation().getImage());
		accommodation.setName(addAccomodationRequest.getAccomodation().getName());
		accommodation.setType(addAccomodationRequest.getAccomodation().getType());
		
		accomodationRepository.save(accommodation);
		
		response.setMessage("Saved accommodation " + accommodation.getName());
		
		
		return response;
	}
	
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "addPeriodRequest")
    @ResponsePayload
	public AddPeriodResponse addPeriodRequest(@RequestPayload AddPeriodRequest addPeriodRequest) {
		
		
		AddPeriodResponse response = new AddPeriodResponse();
		
		Period period = new Period();
		
		period.setFromDate(addPeriodRequest.getPeriod().getFromDate());
		period.setToDate(addPeriodRequest.getPeriod().getToDate());
		period.setAccomodation(addPeriodRequest.getPeriod().getAccomodation());
		
		periodRepository.save(period);
		
		response.setMessage("Saved reserved period from " + period.getFromDate() + " to " + period.getToDate());
				
		return response;
		
	}
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "setPricesRequest")
    @ResponsePayload
	public SetPricesRespone setPricesRequest(@RequestPayload SetPricesRequest setPricesRequest) {
		
		SetPricesRespone response = new SetPricesRespone();
		
		for(Price p : setPricesRequest.getPrices()) {
			
			Price price = new Price();
			
			Accommodation accomodation = p.getAccomodation();
			Agent agent = accomodation.getAgent();
			
			List<Accommodation> accommFromAgent = accomodationRepository.findByAgent(agent);
			
			for(Accommodation ac : accommFromAgent) {
				
				if(accomodation.getId().equals(ac.getIdAgentApp())) {
					
					price.setAccomodation(ac);
					price.setMonth(p.getMonth());
					price.setSum(p.getSum());
					
					priceRepository.save(price);
				}
			}
					
		}
			
		response.setMessage("Saved pricelist");
		
		return response;
	}
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getMessagesForAgentRequest")
    @ResponsePayload
	public GetMessagesForAgentResponse getMessagesForAgentRequest(@RequestPayload GetMessagesForAgentRequest getMessagesForAgentRequest) {
		
		GetMessagesForAgentResponse response = new GetMessagesForAgentResponse();
		
		Agent agent = agentRepository.findOne(getMessagesForAgentRequest.getId());
		
		List<MessageAgent> messagesAgent = messageAgentRepository.findByAgent(agent);
		
		for(MessageAgent ma : messagesAgent) {
			
			response.getMessages().add(ma.getMessage());
			messageAgentRepository.delete(ma);
		}
		
		return response;
		
	}
	
	
	
	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "getReservationsForAgentRequest")
    @ResponsePayload
	public GetReservationsForAgentResponse getReservationsForAgentRequest(@RequestPayload GetReservationsForAgentRequest getReservationsForAgentRequest) {
		
		GetReservationsForAgentResponse response = new GetReservationsForAgentResponse();
		
		Agent agent = agentRepository.findOne(getReservationsForAgentRequest.getId());
		
		List<ReservationAgent> reservationsAgent = reservationAgentRepository.findByAgent(agent);
		
		for(ReservationAgent ra : reservationsAgent) {
			
			response.getReservations().add(ra.getReservation());
			reservationAgentRepository.delete(ra);
			
		}
		
		return response;
		
	}
	
	

	@PayloadRoot(namespace = "http://bookingws.com/soap", localPart = "sendResponseRequest")
    @ResponsePayload
	public SendResponseResponse sendResponseRequest(@RequestPayload SendResponseRequest sendResponseRequest) {
		
		SendResponseResponse response = new SendResponseResponse();
		
		Response resp = new Response();
		resp.setMessage(sendResponseRequest.getResponse().getMessage());
		resp.setRecipient(sendResponseRequest.getResponse().getRecipient());
		resp.setSender(sendResponseRequest.getResponse().getSender());
		resp.setText(sendResponseRequest.getResponse().getText());
		
		responseRepository.save(resp);
		
		
		return response;
	}
	
	
	///////////////
	
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
