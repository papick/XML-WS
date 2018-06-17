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

import XMLWS.model.Addition;
import XMLWS.service.AdditionalServiceService;

@RestController
@RequestMapping(value = "/api/additional-service")
public class AdditionalServiceController {

	@Autowired
	private AdditionalServiceService ass;

	@GetMapping("/get-additional-services")
	public ResponseEntity<List<Addition>> getAdditionalServices() {

		List<Addition> as = ass.getAllServices();

		return new ResponseEntity<List<Addition>>(as, HttpStatus.OK);
	}
	
	@GetMapping("/get-additional-service/{id}")
	public ResponseEntity<Addition> getAdditionalService(@PathVariable Long id) {

		Addition a =  ass.getAService(id);

		return new ResponseEntity<Addition>( a, HttpStatus.OK);
	}

	@PostMapping("/add-additional-service")
	public ResponseEntity<Addition> addAdditionalService(@RequestBody Addition as) {

		Addition asForAdd = ass.addService(as);
		return new ResponseEntity<Addition>(asForAdd, HttpStatus.OK);
	}

	@PutMapping("/edit-additional-service/{id}")
	public ResponseEntity<Addition> editAdditionalService(@PathVariable Long id,
			@RequestBody Addition as) {
		return new ResponseEntity<Addition>(ass.modifyAdditionalService(as, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete-additional-service/{id}")
	public void deleteService(@PathVariable Long id) {
		ass.deleteService(id);
	}

}
