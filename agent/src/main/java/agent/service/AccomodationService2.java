package agent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.AddAccomodationRequest;
import com.bookingws.soap.AddAccomodationResponse;

import agent.model.Accommodation;
import agent.model.Addition;
import agent.repository.AccomodationRepository;
import agent.repository.AditionalServiceRepository;
import agent.repository.AgentRepository;
import agent.repository.CategoryRepository;
import agent.repository.CityRepository;
import agent.repository.TypeAccomodationRepository;
import agent.repository.UserRepository;
import agent.service.dto.AccommodationDTO;

@Service
public class AccomodationService2 {

	@Autowired
	private TypeAccomodationRepository typeAccomodationRepostiroy;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private AccomodationRepository accomodationRepository;

	@Autowired
	private AditionalServiceRepository aditionalServiceRepositroy;

	public Accommodation create(AccommodationDTO accomodationDTO, String username) {
		
		Accommodation accomodation = new Accommodation();
		// accomodation.setImage(accomodationDTO.getImage());
		accomodation.setDescription(accomodationDTO.getDescription());
		int capacity = Integer.parseInt(accomodationDTO.getCapacity());
		accomodation.setCapacity(capacity);	
		accomodation.setType(typeAccomodationRepostiroy.findOneByName(accomodationDTO.getType()));
		// aditonal service
		ArrayList<Addition> aditionals = new ArrayList<Addition>();
		if (accomodationDTO.getList().isEmpty() == false) {
			for (int i = 0; i < accomodationDTO.getList().size(); i++) {
				Addition aditional = aditionalServiceRepositroy.findOneByName(accomodationDTO.getList().get(i));
				aditionals.add(aditional);

			}
			accomodation.setAdditions(aditionals);
		}

		accomodation.setName(accomodationDTO.getName());
		accomodation.setCity(cityRepository.findOneByName(accomodationDTO.getCity()));
		accomodation.setAddress(accomodationDTO.getAddress());
		accomodation.setAgent(agentRepository.findOneByUsername(username));
		accomodation.setCategory(categoryRepository.findOneByName(accomodationDTO.getCategory()));

		accomodationRepository.save(accomodation);
		
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		AddAccomodationRequest request = new AddAccomodationRequest();
		request.setAccomodation(accomodation);
		AddAccomodationResponse response = accomodationServicePort.addAccomodation(request);
		

		return accomodation;
	}

	public Accommodation delete(Long id) {

		Accommodation accomodation = accomodationRepository.findOne(id);

		if (accomodation == null) {
			throw new IllegalArgumentException("Tried to delete non-existant accomodation");
		}
		accomodation.getAdditions().clear();
		accomodationRepository.delete(accomodation);
		return accomodation;
	}

	public Accommodation edit(Long idAgent, Long id, AccommodationDTO accDTO) {

		Accommodation accomodation = accomodationRepository.findOne(id);

		// accomodation.setImage(accomodationDTO.getImage());
		accomodation.setDescription(accDTO.getDescription());
		int capacity = Integer.parseInt(accDTO.getCapacity());
		accomodation.setCapacity(capacity);
		
		accomodation.setType(typeAccomodationRepostiroy.findOneByName(accDTO.getType()));
		// aditonal service
		ArrayList<Addition> aditionals = new ArrayList<Addition>();
		accomodation.getAdditions().clear();
		if (accDTO.getList().isEmpty() == false) {
			for (int i = 0; i < accDTO.getList().size(); i++) {
				Addition aditional = aditionalServiceRepositroy.findOneByName(accDTO.getList().get(i));
				aditionals.add(aditional);

			}
			accomodation.setAdditions(aditionals);
		}

		accomodation.setName(accDTO.getName());
		accomodation.setCity(cityRepository.findOneByName(accDTO.getCity()));
		accomodation.setAddress(accDTO.getAddress());
		accomodation.setAgent(agentRepository.findOne(idAgent));
		accomodation.setCategory(categoryRepository.findOneByName(accDTO.getCategory()));

		accomodationRepository.save(accomodation);

		return null;

	}

}
