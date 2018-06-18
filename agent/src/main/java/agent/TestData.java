package agent;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import agent.model.Accommodation;
import agent.model.Addition;
import agent.model.Category;
import agent.model.City;
import agent.model.Country;
import agent.model.TypeAccomodation;
import agent.model.User;
import agent.repository.AccomodationRepository;
import agent.repository.AditionalServiceRepository;
import agent.repository.CategoryRepository;
import agent.repository.CityRepository;
import agent.repository.CountryRepository;
import agent.repository.TypeAccomodationRepository;
import agent.repository.UserRepository;

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
	private UserRepository userRepository;

	@Autowired
	private AditionalServiceRepository aditionalServiceRepository;

	@Autowired
	private AccomodationRepository accomodationRepository;

	@PostConstruct
	private void init() {
		Country country1 = new Country();
		country1.setName("Serbia");
		countryRepository.save(country1);

		Country country2 = new Country();
		country2.setName("United States");
		countryRepository.save(country2);

		City city1 = new City("Novi Sad", country1);
		cityRepository.save(city1);

		City city2 = new City("Nidri Lefkafa", country2);
		cityRepository.save(city2);

		Category category1 = new Category("***");
		categoryRepository.save(category1);

		TypeAccomodation typeAccomodation1 = new TypeAccomodation("Apartman");
		typeAccomodationRepository.save(typeAccomodation1);

		User user1 = new User("dejan", "dejan", "dejan@gmail.com", "");
		userRepository.save(user1);

		Addition aditionalService1 = new Addition("TV");
		Addition aditionalService2 = new Addition("Wi-Fi");
		Addition aditionalService3 = new Addition("Klima");
		Addition aditionalService4 = new Addition("Mini kuhinja");

		aditionalServiceRepository.save(aditionalService1);
		aditionalServiceRepository.save(aditionalService2);
		aditionalServiceRepository.save(aditionalService3);
		aditionalServiceRepository.save(aditionalService4);

		Accommodation accomodation1 = new Accommodation();
		accomodation1.setImage("");
		accomodation1.setDescription("Ionnian Paradise apartmani se nalaze u centru Nidrija,  na  100m od plaze.");
		accomodation1.setCapacity(2);
		accomodation1.setPrice(220.0);
		accomodation1.setType(typeAccomodation1);
		accomodation1.setName("Ionnian Paradise");
		accomodation1.setCity(city2);
		accomodation1.setAddress("");
		accomodation1.setAgent(user1);
		accomodation1.setCategory(category1);
		ArrayList<Addition> lista = new ArrayList<Addition>();
		lista.add(aditionalService1);
		lista.add(aditionalService2);
		lista.add(aditionalService3);
		lista.add(aditionalService4);

		accomodation1.setAdditional(lista);

		accomodationRepository.save(accomodation1);
		
		
		
		Accommodation accomodation2 = new Accommodation();
		accomodation2.setImage("");
		accomodation2.setDescription("Nalazi se u samom centru Novog Sada.");
		accomodation2.setCapacity(3);
		accomodation2.setPrice(50.0);
		accomodation2.setType(typeAccomodation1);
		accomodation2.setName("Hotel Centar");
		accomodation2.setCity(city1);
		accomodation2.setAddress("");
		accomodation2.setAgent(user1);
		accomodation2.setCategory(category1);
		ArrayList<Addition> lista2 = new ArrayList<Addition>();
		lista2.add(aditionalService1);
		lista2.add(aditionalService2);
		lista2.add(aditionalService3);


		accomodation2.setAdditional(lista2);

		accomodationRepository.save(accomodation2);

	}
}