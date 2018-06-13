package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.AdditionalService;

@Repository
public interface AditionalServiceRepository extends JpaRepository<AdditionalService, Long> {

}
