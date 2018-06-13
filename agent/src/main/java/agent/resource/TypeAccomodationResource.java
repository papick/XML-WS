package agent.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.TypeAccomodation;
import agent.resource.response.ResponseTypeAccomodation;
import agent.service.TypeAccomodationService;

@RestController
@RequestMapping(value = "/api/type-accomodation")
public class TypeAccomodationResource {

	@Autowired
	private TypeAccomodationService typeAccomodationService;

	@GetMapping("/all-type-accomodations")
	public ResponseEntity<ResponseTypeAccomodation> getCities() {

		ArrayList<TypeAccomodation> types = typeAccomodationService.getAllTypeAccomodations();

		return new ResponseEntity<>(new ResponseTypeAccomodation(types), HttpStatus.OK);
	}

}
