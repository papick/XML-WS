package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Agent;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long>{
	
	Agent findByUsername(String username);

}
