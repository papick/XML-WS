package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Agent;
import XMLWS.repository.AgentRepository;
import XMLWS.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepo;

	@Override
	public List<Agent> getAllAgents() {
		return (List<Agent>) agentRepo.findAll();
	}

	@Override
	public Agent addAgent(Agent a) {
		Agent newA = new Agent();
		newA.setAddress(a.getAddress());
		newA.setMbr(a.getMbr());
		newA.setName(a.getName());
		newA.setPassword(a.getPassword());
		newA.setSurname(a.getSurname());
		newA.setUsername(a.getUsername());
		return agentRepo.save(newA);
	}

	@Override
	public Agent modifyAgent(Agent a, Long id) {
		Agent updated = agentRepo.findOne(id);
		updated.setAddress(a.getAddress());
		updated.setMbr(a.getMbr());
		updated.setName(a.getName());
		updated.setPassword(a.getPassword());
		updated.setSurname(a.getSurname());
		updated.setUsername(a.getUsername());
		return agentRepo.save(updated);

	}

	@Override
	public void deleteAgent(Long id) {
		Agent agentForDelete=agentRepo.findOne(id);
		if (agentForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant agent");
		}
		agentRepo.delete(agentForDelete);
	}

}
