package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.AdditionalService;
import XMLWS.repository.AdditionalServiceRepository;
import XMLWS.service.AdditionalServiceService;

@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService {

	@Autowired
	private AdditionalServiceRepository asRepo;

	@Override
	public List<AdditionalService> getAllServices() {
		return (List<AdditionalService>) asRepo.findAll();
	}

	@Override
	public AdditionalService addService(AdditionalService as) {
		AdditionalService newAS = new AdditionalService();
		newAS.setName(as.getName());
		return asRepo.save(newAS);
	}

	@Override
	public AdditionalService modifyAdditionalService(AdditionalService as, Long id) {
		AdditionalService updated = asRepo.findOne(id);
		updated.setName(as.getName());
		return asRepo.save(updated);
	}

	@Override
	public void deleteService(Long id) {
		AdditionalService serviceForDelete = asRepo.findOne(id);
		if (serviceForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant additional service");
		}
		asRepo.delete(serviceForDelete);
	}

}
