package agent.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Accommodation;
import agent.repository.AccomodationRepository;
import agent.resource.response.ResponseAccomodations;
import agent.service.AccomodationService2;
import agent.service.dto.AccommodationDTO;

@RestController
@RequestMapping(value = "/api/accomodation")
public class AccomodationResource {

	@Autowired
	private AccomodationService2 accomodationService;

	@Autowired
	private AccomodationRepository accomodationRepository;

	@PostMapping("/create/{username}")
	public void createAccomodation(@RequestBody AccommodationDTO accomodationDTO, @PathVariable String username) {

		accomodationService.create(accomodationDTO, username);

	}

	@GetMapping("/all-accomodations")
	public ResponseEntity<ResponseAccomodations> getAccomodations() {

		ArrayList<Accommodation> accomodations = (ArrayList<Accommodation>) accomodationRepository.findAll();

		return new ResponseEntity<>(new ResponseAccomodations(accomodations), HttpStatus.OK);
	}

	@DeleteMapping("/delete-accomodation/{id}")
	public ResponseEntity<Accommodation> deleteAccomodation(@PathVariable Long id) {

		Accommodation accomodation = accomodationService.delete(id);
		return new ResponseEntity<>(accomodation, HttpStatus.OK);
	}

	@GetMapping("/get-accomodation/{id}")
	public ResponseEntity<Accommodation> getAccomodation(@PathVariable Long id) {

		Accommodation accomodation = accomodationRepository.findOne(id);
		if (accomodation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(accomodation, HttpStatus.OK);
	}

	@PutMapping("/edit-accomodation/{idAgent}/{id}")
	public ResponseEntity<Accommodation> editAccomodation(@PathVariable Long idAgent, @PathVariable Long id,
			@RequestBody AccommodationDTO accomodationDTO) {

		Accommodation accomodation = accomodationService.edit(idAgent, id, accomodationDTO);
		return new ResponseEntity<>(accomodation, HttpStatus.OK);

	}

}
