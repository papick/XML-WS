package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.dto.AccomodationDTO;
import XMLWS.model.Accommodation;
import XMLWS.model.Period;
import XMLWS.service.AccomodationService;
import XMLWS.service.PeriodService;

@RestController
@RequestMapping(value = "/api/accomodations")
public class AccomodationController {
	
	@Autowired
	private AccomodationService accomodationService;
	
	@Autowired
	private PeriodService periodService;
	
	@GetMapping
	public List<Accommodation> getAccomodations() {
		
		return accomodationService.getAllAccomodations();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AccomodationDTO> getAccomodations(@PathVariable Long id) {
		Accommodation accomodation = accomodationService.getAccomodation(id);
		if(accomodation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<Period> periods = periodService.getAllPeriodsByAccomodation(id);
		AccomodationDTO dto = new AccomodationDTO(accomodation, periods);
		return new ResponseEntity<AccomodationDTO>(dto , HttpStatus.OK);
	}
	
}
