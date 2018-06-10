package XMLWS;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.Country;
import XMLWS.model.TypeAccomodation;
import XMLWS.model.User;
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
	private UserRepository userRepository;

	@PostConstruct
	private void init() {

		Country country1 = new Country("Serbia");
		countryRepository.save(country1);

		City city1 = new City("Novi Sad", country1);
		cityRepository.save(city1);

		Category category1 = new Category("***");
		categoryRepository.save(category1);

		TypeAccomodation typeAccomodation1 = new TypeAccomodation("Studio");
		typeAccomodationRepository.save(typeAccomodation1);

		User user1 = new User("dejan", "dejan", "dejan@gmail.com", "");
		userRepository.save(user1);

	}
}