package XMLWS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import XMLWS.model.Accommodation;
import XMLWS.repository.AccomodationRepository;
import XMLWS.repository.CategoryRepository;
import XMLWS.repository.CityRepository;
import XMLWS.repository.TypeAccomodationRepository;
import XMLWS.repository.UserRepository;
import XMLWS.service.AccomodationWService;

public class AccomodationWServiceImpl implements AccomodationWService {

	@Autowired
	private TypeAccomodationRepository typeAccomodationRepostiroy;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AccomodationRepository accomodationRepository;

	@Override
	public Accommodation create(Accommodation accomodation) {

		Accommodation acc = new Accommodation();

		acc.setImage(accomodation.getImage());
		acc.setDescription(accomodation.getDescription());
		acc.setCapacity(accomodation.getCapacity());
		acc.setPrice(accomodation.getPrice());
		acc.setType(typeAccomodationRepostiroy.findOneByName(accomodation.getType().getName()));
		// sditonal service dodati
		acc.setName(accomodation.getName());
		acc.setCity(cityRepository.findOneByName(accomodation.getCity().getName()));
		acc.setAddress(accomodation.getAddress());
		acc.setAgent(userRepository.findOne(accomodation.getAgent().getId()));
		acc.setCategory(categoryRepository.findOneByName(accomodation.getCategory().getName()));
		acc.setIdAccomodationAgent(accomodation.getId());

		accomodationRepository.save(acc);
		
		return acc;
	}

}
