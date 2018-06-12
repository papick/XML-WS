package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.AdditionalService;
import XMLWS.service.AdditionalServiceService;

@RestController
@RequestMapping(value = "/api/additional-service")
public class AdditionalServiceController {
	
	@Autowired
	private AdditionalServiceService ass;
	
	@GetMapping("/get-additional-services")
	public ResponseEntity<List<AdditionalService>> getAdditionalServices() {
		
		List<AdditionalService> as = ass.getAllServices();

		return new ResponseEntity<List<AdditionalService>>(as, HttpStatus.OK);
	}

}
