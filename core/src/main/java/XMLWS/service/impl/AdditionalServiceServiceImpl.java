package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Addition;
import XMLWS.repository.AdditionalServiceRepository;
import XMLWS.service.AdditionalServiceService;


@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService {

	@Autowired
	private AdditionalServiceRepository asRepo;

	@Override
	public List<Addition> getAllServices() {
		return (List<Addition>) asRepo.findAll();
	}

	@Override
	public Addition addService(Addition as) {
		Addition newAS = new Addition();
		newAS.setName(as.getName());
		return asRepo.save(newAS);
	}

	@Override
	public Addition modifyAdditionalService(Addition as, Long id) {
		Addition updated = asRepo.findOne(id);
		updated.setName(as.getName());
		return asRepo.save(updated);
	}

	@Override
	public void deleteService(Long id) {
		Addition serviceForDelete = asRepo.findOne(id);
		if (serviceForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant additional service");
		}
		asRepo.delete(serviceForDelete);
	}

	@Override
	public Addition getAService(Long id) {
		return asRepo.findOne(id);
	}

}
