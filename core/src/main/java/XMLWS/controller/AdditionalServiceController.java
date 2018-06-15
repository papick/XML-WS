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
	
	@GetMapping("/get-additional-service/{id}")
	public ResponseEntity<AdditionalService> getAdditionalService(@PathVariable Long id) {

		AdditionalService a = ass.getAService(id);

		return new ResponseEntity<AdditionalService>(a, HttpStatus.OK);
	}

	@PostMapping("/add-additional-service")
	public ResponseEntity<AdditionalService> addAdditionalService(@RequestBody AdditionalService as) {

		AdditionalService asForAdd = ass.addService(as);
		return new ResponseEntity<AdditionalService>(asForAdd, HttpStatus.OK);
	}

	@PutMapping("/edit-additional-service/{id}")
	public ResponseEntity<AdditionalService> editAdditionalService(@PathVariable Long id,
			@RequestBody AdditionalService as) {
		return new ResponseEntity<AdditionalService>(ass.modifyAdditionalService(as, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete-additional-service/{id}")
	public void deleteService(@PathVariable Long id) {
		ass.deleteService(id);
	}

}
