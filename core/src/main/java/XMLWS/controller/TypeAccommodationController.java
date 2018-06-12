package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.TypeAccomodation;
import XMLWS.service.TypeAccomodationService;

@RestController
@RequestMapping(value = "/api/type-accommodation")
public class TypeAccommodationController {

	@Autowired
	private TypeAccomodationService tas;

	@GetMapping("/get-types")
	public ResponseEntity<List<TypeAccomodation>> getTypeAccommodation() {
		
		List<TypeAccomodation> t = tas.getAllTypes();

		return new ResponseEntity<List<TypeAccomodation>>(t, HttpStatus.OK);
	}

}
