package XMLWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Accommodation;
import XMLWS.model.Agent;

@Repository
public interface AccomodationRepository extends JpaRepository<Accommodation, Long>{

	List<Accommodation> findByCityNameIgnoreCaseContainingAndCapacity(String cityName, int capacity);
	
	List<Accommodation> findByAgent(Agent agent);


}
