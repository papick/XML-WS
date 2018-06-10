package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Agent;

@Service
public interface AgentService {
	
	public List<Agent> getAllAgents();
	
	public Agent addAgent(Agent a);
	
	public Agent modifyAgent(Agent a,Long id);
	
	public void deleteAgent(Long id);

}
