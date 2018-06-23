package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Accommodation;

@Repository
public interface AccomodationRepository extends JpaRepository<Accommodation, Long>{
	
	

}
