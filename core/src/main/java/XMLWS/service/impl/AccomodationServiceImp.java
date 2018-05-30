package XMLWS.service.impl;

import javax.jws.WebService;

import XMLWS.model.Accommodation;
import XMLWS.service.AccomodationService;
//@EnableWs
@WebService(targetNamespace="http://www.ftn.uns.ac.rs/booking", serviceName="accomodationService", endpointInterface="XMLWS.service.AccomodationService")
public class AccomodationServiceImp implements AccomodationService {

	@Override
	public Accommodation create(Accommodation acc) {
		System.out.println(acc.getCapacity());
		return acc;
	}

}
