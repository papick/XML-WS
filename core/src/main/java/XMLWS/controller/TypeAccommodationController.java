package XMLWS.controller;

import java.util.List;

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
	
	@PostMapping("/add-type")
	public ResponseEntity<TypeAccomodation> addType(@RequestBody TypeAccomodation ta) {

		TypeAccomodation taForAdd = tas.addType(ta);
		return new ResponseEntity<TypeAccomodation>(taForAdd, HttpStatus.OK);
	}
	
	@PutMapping("/edit-type/{id}")
	public ResponseEntity<TypeAccomodation> editType(@PathVariable Long id,@RequestBody TypeAccomodation ta) {
		return new ResponseEntity<TypeAccomodation>(tas.modifyType(ta, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-type/{id}")
	public void deleteType(@PathVariable Long id) {
		tas.deleteType(id);
	}

}
