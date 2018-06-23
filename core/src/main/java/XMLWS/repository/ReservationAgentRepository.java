package XMLWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Agent;
import XMLWS.model.ReservationAgent;

@Repository
public interface ReservationAgentRepository extends JpaRepository<ReservationAgent, Long>{
	
	List<ReservationAgent> findByAgent(Agent agent);

}
