package agent.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Accommodation;
import agent.service.AccomodationService;
import agent.service.dto.AccommodationDTO;

@RestController
@RequestMapping(value = "/api/accomodation")
public class AccomodationResource {

	@Autowired
	private AccomodationService accomodationService;

	@PostMapping("/create")
	public void createAccomodation(@RequestBody AccommodationDTO accomodationDTO) {

		Accommodation accomodation = accomodationService.create(accomodationDTO);

	}

}
