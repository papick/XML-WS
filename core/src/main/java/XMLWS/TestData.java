package XMLWS;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import XMLWS.model.AdditionalService;
import XMLWS.model.Agent;
import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.Country;
import XMLWS.model.TypeAccomodation;
import XMLWS.model.User;
import XMLWS.repository.AdditionalServiceRepository;
import XMLWS.repository.AgentRepository;
import XMLWS.repository.CategoryRepository;
import XMLWS.repository.CityRepository;
import XMLWS.repository.CountryRepository;
import XMLWS.repository.TypeAccomodationRepository;
import XMLWS.repository.UserRepository;

@Component
public class TestData {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TypeAccomodationRepository typeAccomodationRepository;

	@Autowired
	private AdditionalServiceRepository additionalServiceRepo;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AgentRepository agentRepo;

	@PostConstruct
	private void init() {

		Country country1 = new Country("Serbia");
		countryRepository.save(country1);

		City city1 = new City("Novi Sad", country1);
		cityRepository.save(city1);

		Category category1 = new Category("*");
		categoryRepository.save(category1);

		Category category2 = new Category("**");
		categoryRepository.save(category2);

		Category category3 = new Category("***");
		categoryRepository.save(category3);

		Category category4 = new Category("****");
		categoryRepository.save(category4);

		Category category5 = new Category("*****");
		categoryRepository.save(category5);

		TypeAccomodation typeAccomodation1 = new TypeAccomodation("Studio");
		typeAccomodationRepository.save(typeAccomodation1);

		TypeAccomodation typeAccomodation2 = new TypeAccomodation("Apartman");
		typeAccomodationRepository.save(typeAccomodation2);

		AdditionalService additionalService1 = new AdditionalService("Klima");
		additionalServiceRepo.save(additionalService1);

		AdditionalService additionalService2 = new AdditionalService("Parking");
		additionalServiceRepo.save(additionalService2);

		AdditionalService additionalService3 = new AdditionalService("Spa");
		additionalServiceRepo.save(additionalService3);

		User user1 = new User("dejan", "dejan", "dejan@gmail.com", false);
		userRepository.save(user1);
		
		User klijent1 = new User("kris", "kris", "kristina@gmail.com", true);
		userRepository.save(klijent1);
		
		User klijent2 = new User("milica", "milica", "milica@gmail.com", true);
		userRepository.save(klijent2);
		
		User klijent3 = new User("dejanmijic", "dejan", "dejanmijic@gmail.com", true);
		userRepository.save(klijent3);
		
		User klijent4 = new User("sinisa", "sinisa", "sinisa@gmail.com", true);
		userRepository.save(klijent4);
		
		User blocked = new User("luka", "luka", "luka@gmail.com", false);
		userRepository.save(blocked);
		
		Agent agent1=new Agent("sheraton","sheraton","Marko","Markovic","Novi Sad","mbr1");
		agentRepo.save(agent1);
		
		Agent agent2=new Agent("hilton","hilton","Jovan","Jovanovic","Beograd","mbr2");
		agentRepo.save(agent2);

	}
}