package agent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.TypeAccomodation;
import agent.repository.TypeAccomodationRepository;

@Service
public class TypeAccomodationService {

	@Autowired
	private TypeAccomodationRepository typeAccomodationRepositroy;
	
	public ArrayList<TypeAccomodation> getAllTypeAccomodations(){
		return (ArrayList<TypeAccomodation>) typeAccomodationRepositroy.findAll();
	}
}
