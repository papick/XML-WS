package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.TypeAccomodation;
import XMLWS.repository.TypeAccomodationRepository;
import XMLWS.service.TypeAccomodationService;

@Service
public class TypeAccomodationServiceImpl implements TypeAccomodationService {

	@Autowired
	private TypeAccomodationRepository typeRepo;

	@Override
	public List<TypeAccomodation> getAllTypes() {
		return (List<TypeAccomodation>) typeRepo.findAll();
	}

	@Override
	public TypeAccomodation getType(Long id) {
		return typeRepo.findOne(id);
	}

	@Override
	public TypeAccomodation addType(TypeAccomodation ta) {
		TypeAccomodation newTA = new TypeAccomodation();
		newTA.setName(ta.getName());
		return typeRepo.save(newTA);
	}

	@Override
	public TypeAccomodation modifyType(TypeAccomodation ta, Long id) {
		TypeAccomodation updated = typeRepo.findOne(id);
		updated.setName(ta.getName());
		return typeRepo.save(updated);
	}

	@Override
	public void deleteType(Long id) {
		TypeAccomodation typeForDelete = typeRepo.findOne(id);
		if (typeForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant type");
		}
		typeRepo.delete(typeForDelete);
	}

}
