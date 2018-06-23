package XMLWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Agent;
import XMLWS.model.MessageAgent;

@Repository
public interface MessageAgentRepository extends JpaRepository<MessageAgent, Long> {

	List<MessageAgent> findByAgent(Agent agent);
}
