package XMLWS;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import XMLWS.model.Accommodation;
import XMLWS.model.Addition;
import XMLWS.model.Agent;
import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.Comment;
import XMLWS.model.Country;
import XMLWS.model.TypeAccomodation;
import XMLWS.model.User;
import XMLWS.repository.AccomodationRepository;
import XMLWS.repository.AdditionalServiceRepository;
import XMLWS.repository.AgentRepository;
import XMLWS.repository.CategoryRepository;
import XMLWS.repository.CityRepository;
import XMLWS.repository.CommentRepository;
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
	
	@Autowired
	private AccomodationRepository accomodationRepository;
	
	@Autowired
	private CommentRepository commRepo;

	@PostConstruct
	private void init() {

		Country country1 = new Country("Serbia");
		countryRepository.save(country1);
		
		Country country2 = new Country();
		country2.setCode("USA");
		country2.setName("United States of America");
		countryRepository.save(country2);
				
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

		Addition additionalService1 = new Addition("Klima");
		additionalServiceRepo.save(additionalService1);

		Addition additionalService2 = new Addition("Parking");
		additionalServiceRepo.save(additionalService2);

		Addition additionalService3 = new Addition("Spa");
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
		
		Agent agent1=new Agent("sheraton","sheraton","Marko","Markovic","Novi Sad");
		agentRepo.save(agent1);
		
		Agent agent2=new Agent("hilton","hilton","Jovan","Jovanovic","Beograd");
		agentRepo.save(agent2);
		
		Accommodation a1= new Accommodation("", "", 2, 20, typeAccomodation1,"naziv",city1, "", user1,category4,agent1.getId());
		accomodationRepository.save(a1);
		
		Comment comm1=new Comment("Odlican smestaj!", "Kristina", a1, false);
		commRepo.save(comm1);
		
		Comment comm2=new Comment("Los smestaj!", "Milica", a1, false);
		commRepo.save(comm2);
		
		Comment comm3=new Comment("Lep smestaj!", "Dejan", a1, false);
		commRepo.save(comm3);
		
		Comment comm4=new Comment("Psovka", "Kristina", a1, false);
		commRepo.save(comm4);
		
		Comment comm5=new Comment("Bla bla", "Sinisa", a1, true);
		commRepo.save(comm5);

	}
}