package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.AdditionalService;

@Service
public interface AdditionalServiceService {
	
	public List<AdditionalService> getAllServices();
	
	public AdditionalService addService(AdditionalService as);
	
	public AdditionalService modifyAdditionalService(AdditionalService as,Long id);
	
	public void deleteService(Long id);

}
