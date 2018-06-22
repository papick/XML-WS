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
import XMLWS.model.Period;
import XMLWS.model.Reservation;
import XMLWS.model.TypeAccomodation;
import XMLWS.model.User;
import XMLWS.repository.AccomodationRepository;
import XMLWS.repository.AdditionalServiceRepository;
import XMLWS.repository.AgentRepository;
import XMLWS.repository.CategoryRepository;
import XMLWS.repository.CityRepository;
import XMLWS.repository.CommentRepository;
import XMLWS.repository.CountryRepository;
import XMLWS.repository.PeriodRepository;
import XMLWS.repository.ReservationRepository;
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

	@Autowired
	private PeriodRepository periodRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@PostConstruct
	private void init() {

		Country country1 = new Country("Serbia");
		country1.setCode("SRB");

		countryRepository.save(country1);

		Country country2 = new Country();
		country2.setCode("USA");
		country2.setName("United States of America");
		countryRepository.save(country2);

		City city1 = new City("Beograd", country1);
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

		User user1 = new User("dejan", "dejan123", "dejan@gmail.com", false);
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

		Agent agent1 = new Agent("sheraton", "sheraton", "Marko", "Markovic", "Novi Sad");
		agentRepo.save(agent1);

		Agent agent2 = new Agent("hilton", "hilton", "Jovan", "Jovanovic", "Beograd");
		agentRepo.save(agent2);

		String image1 = "https://pix6.agoda.net/hotelImages/115/1157073/1157073_16062412150044053329.jpg";

		Accommodation a1 = new Accommodation(image1, "", 2, typeAccomodation1, "Seraton Novi Sad", city1, "", agent1,
				category4);

		accomodationRepository.save(a1);

		Comment comm1 = new Comment("Odlican smestaj!", "Kristina", a1, false);
		commRepo.save(comm1);

		Comment comm2 = new Comment("Los smestaj!", "Milica", a1, false);
		commRepo.save(comm2);

		Comment comm3 = new Comment("Lep smestaj!", "Dejan", a1, false);
		commRepo.save(comm3);

		Comment comm4 = new Comment("Psovka", "Kristina", a1, false);
		commRepo.save(comm4);

		Comment comm5 = new Comment("Bla bla", "Sinisa", a1, true);
		commRepo.save(comm5);

		Period period1 = new Period();
		period1.setAccomodation(a1);
		period1.setFromDate("2018-07-20");
		period1.setToDate("2018-08-01");
		periodRepository.save(period1);

		Reservation reservation1 = new Reservation();
		reservation1.setConfirmed(false);
		reservation1.setPeriod(period1);
		reservation1.setUser(user1);
		reservationRepository.save(reservation1);

		Period period2 = new Period();
		period2.setAccomodation(a1);
		period2.setFromDate("2018-05-05");
		period2.setToDate("2018-05-10");
		periodRepository.save(period2);

		Reservation reservation2 = new Reservation();
		reservation2.setConfirmed(true);
		reservation2.setPeriod(period2);
		reservation2.setUser(user1);
		reservationRepository.save(reservation2);

	}
}