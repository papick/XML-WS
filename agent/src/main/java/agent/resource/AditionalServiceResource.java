package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetAdditionsRequest;
import com.bookingws.soap.GetAdditionsResponse;

import agent.model.Addition;
import agent.repository.AditionalServiceRepository;
import agent.resource.response.ResponseAditionalServices;
import agent.service.AditionalService;

@RestController
@RequestMapping(value = "/api/aditional-service")
public class AditionalServiceResource {

	@Autowired
	private AditionalService aditionalService;
	
	@Autowired 
	private AditionalServiceRepository additonalServiceRepository;

	@GetMapping("/all-aditional-services")
	public ResponseEntity<ResponseAditionalServices> getAditionalSevices() {

		
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		GetAdditionsRequest request = new GetAdditionsRequest();
		request.setName("all");
		GetAdditionsResponse response = accomodationServicePort.getAdditions(request);
		
		List<Addition> services = response.getAdditions();

		for(Addition addition : services) {
			additonalServiceRepository.save(addition);
		}
		
		return new ResponseEntity<>(new ResponseAditionalServices(services), HttpStatus.OK);
	}

}
