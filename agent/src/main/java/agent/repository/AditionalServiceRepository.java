package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Additional;

@Repository
public interface AditionalServiceRepository extends JpaRepository<Additional, Long> {

	Additional findOneByName(String name);
}
