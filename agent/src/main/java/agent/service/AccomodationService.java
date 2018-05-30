package agent.service;

import javax.jws.WebService;

import agent.model.Accommodation;



@WebService(targetNamespace="http://www.ftn.uns.ac.rs/booking", serviceName="accomodationService")
public interface AccomodationService {

		Accommodation create(Accommodation accomodation);
}
