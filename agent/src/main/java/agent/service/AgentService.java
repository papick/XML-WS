package agent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.model.Agent;
import agent.repository.AgentRepository;
import agent.service.dto.AgentDTO;

@Transactional
@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository;

	public Agent logIn(AgentDTO agentDTO) {

		Agent agent = agentRepository.findOneByUsername(agentDTO.getUsername());
		if (agent == null) {
			throw new IllegalArgumentException("Agent not found!");
		}

		if (agent.getPassword().equals(agentDTO.getPassword())) {
			return agent;
		}

		return null;
	}
}
