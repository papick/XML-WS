package XMLWS.service;

import javax.jws.WebService;

import XMLWS.model.Accommodation;

@WebService(targetNamespace="http://www.ftn.uns.ac.rs/booking", serviceName="accomodationWService")
public interface AccomodationWService {

		Accommodation create(Accommodation accomodation);
}
