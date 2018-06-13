package agent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Additional;
import agent.repository.AditionalServiceRepository;

@Service
public class AditionalService {

	@Autowired
	private AditionalServiceRepository aditionalServicerepository;

	public ArrayList<Additional> getAllAditionalServices() {
		return (ArrayList<Additional>) aditionalServicerepository.findAll();
	}
}
