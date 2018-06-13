package agent.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Accommodation;
import agent.repository.AccomodationRepository;
import agent.resource.response.ResponseAccomodations;
import agent.service.AccomodationService;
import agent.service.dto.AccommodationDTO;

@RestController
@RequestMapping(value = "/api/accomodation")
public class AccomodationResource {

	@Autowired
	private AccomodationService accomodationService;

	@Autowired
	private AccomodationRepository accomodationRepository;

	@PostMapping("/create")
	public void createAccomodation(@RequestBody AccommodationDTO accomodationDTO) {

		Accommodation accomodation = accomodationService.create(accomodationDTO);

	}

	@GetMapping("/all-accomodations")
	public ResponseEntity<ResponseAccomodations> getAccomodations() {

		ArrayList<Accommodation> accomodations = (ArrayList<Accommodation>) accomodationRepository.findAll();

		return new ResponseEntity<>(new ResponseAccomodations(accomodations), HttpStatus.OK);
	}

}
