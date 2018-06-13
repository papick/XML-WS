package agent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Accommodation;
import agent.repository.AccomodationRepository;
import agent.repository.CategoryRepository;
import agent.repository.CityRepository;
import agent.repository.TypeAccomodationRepository;
import agent.repository.UserRepository;
import agent.service.dto.AccommodationDTO;

@Service
public class AccomodationService {

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

	public Accommodation create(AccommodationDTO accomodationDTO, Long id) {
		Accommodation accomodation = new Accommodation();
		// accomodation.setImage(accomodationDTO.getImage());
		accomodation.setDescription(accomodationDTO.getDescription());
		accomodation.setCapacity(accomodationDTO.getCapacity());
		accomodation.setPrice(accomodationDTO.getPrice());
		accomodation.setType(typeAccomodationRepostiroy.findOneByName(accomodationDTO.getType()));
		// aditonal service dodati
		accomodation.setName(accomodationDTO.getName());
		accomodation.setCity(cityRepository.findOneByName(accomodationDTO.getCity()));
		accomodation.setAddress(accomodationDTO.getAddress());
		accomodation.setAgent(userRepository.findOne(id));
		accomodation.setCategory(categoryRepository.findOneByName(accomodationDTO.getCategory()));

		accomodationRepository.save(accomodation);

		return accomodation;
	}

	public Accommodation delete(Long id) {

		Accommodation accomodation = accomodationRepository.findOne(id);

		if (accomodation == null) {
			throw new IllegalArgumentException("Tried to delete non-existant accomodation");
		}
		accomodation.getAdditional().clear();
		accomodationRepository.delete(accomodation);
		return accomodation;
	}

}
