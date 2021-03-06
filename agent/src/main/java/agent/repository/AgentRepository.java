package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

	Agent findOneByUsername(String username);

}
