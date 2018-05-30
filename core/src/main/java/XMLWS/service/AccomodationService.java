package XMLWS.service;

import javax.jws.WebService;

import XMLWS.model.Accommodation;

@WebService(targetNamespace="http://www.ftn.uns.ac.rs/booking", serviceName="accomodationService")
public interface AccomodationService {

		Accommodation create(Accommodation accomodation);
}
