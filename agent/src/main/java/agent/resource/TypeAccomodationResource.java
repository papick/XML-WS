package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetTypesAccomodationRequest;
import com.bookingws.soap.GetTypesAccomodationResponse;

import agent.model.Country;
import agent.model.TypeAccomodation;
import agent.service.TypeAccomodationService;

@RestController
@RequestMapping(value = "/api/type-accomodation")
public class TypeAccomodationResource {

	@Autowired
	private TypeAccomodationService typeAccomodationService;

	@RequestMapping(method = RequestMethod.GET,
            value = "/get-types",
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TypeAccomodation>> getTypes() {
		
		// Country country = new Country();
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		GetTypesAccomodationRequest request = new GetTypesAccomodationRequest();
		request.setName("all");;
		GetTypesAccomodationResponse response = accomodationServicePort.getTypesAccomodation(request);
		List<TypeAccomodation> types = response.getTypesAccomodation();
		
		
		return new ResponseEntity<>(types, HttpStatus.OK);
	}


}
