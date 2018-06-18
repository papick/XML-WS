package agent.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Addition;
import agent.resource.response.ResponseAditionalServices;
import agent.service.AditionalService;

@RestController
@RequestMapping(value = "/api/aditional-service")
public class AditionalServiceResource {

	@Autowired
	private AditionalService aditionalService;

	@GetMapping("/all-aditional-services")
	public ResponseEntity<ResponseAditionalServices> getAditionalSevices() {

		ArrayList<Addition> services = aditionalService.getAllAditionalServices();

		return new ResponseEntity<>(new ResponseAditionalServices(services), HttpStatus.OK);
	}

}
