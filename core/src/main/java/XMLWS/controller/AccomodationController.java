package XMLWS.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.dto.AccomodationDTO;
import XMLWS.dto.AccomodationSearchDTO;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<AccomodationDTO> getAccomodations(@PathVariable Long id) {
		Accommodation accomodation = accomodationService.getAccomodation(id);
		if(accomodation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<Period> periods = periodService.getAllPeriodsByAccomodation(id);
		AccomodationDTO dto = new AccomodationDTO(accomodation, periods);
		return new ResponseEntity<AccomodationDTO>(dto , HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public List<Accommodation> getAccomodationsSearch(@RequestBody AccomodationSearchDTO search) {
		List<Accommodation> accomodations=accomodationService.getAccomodationBySearch(search.getCity(), search.getCapacity());
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = Date.valueOf(search.getFromDate());
		    toDate = Date.valueOf(search.getToDate());
		}catch (Exception e) {
			return null;
		}
		List<Accommodation> retVal = new ArrayList<>();
		for(Accommodation accommodation : accomodations) {
			List<Period> periods = periodService.getAllPeriodsByAccomodation(accommodation.getId());
			boolean flag = true;
			for(Period period : periods) {
				Date from =  Date.valueOf(period.getFromDate());
				Date to =  Date.valueOf(period.getToDate());
				if( fromDate.compareTo(to) <= 0  &&  toDate.compareTo(from) >= 0 ) {
					flag = false;
				}
				
				
			}
			if(flag) {
				retVal.add(accommodation);
			}
		}
		
		return retVal;
	}
	
	
	
}
