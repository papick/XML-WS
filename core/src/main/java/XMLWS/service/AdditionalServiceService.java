package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Addition;

@Service
public interface AdditionalServiceService {
	
	public List<Addition> getAllServices();
	
	public Addition addService(Addition as);
	
	public Addition modifyAdditionalService(Addition as,Long id);
	
	public void deleteService(Long id);

}
