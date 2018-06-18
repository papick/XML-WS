package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Addition;

@Repository
public interface AditionalServiceRepository extends JpaRepository<Addition, Long> {

	Addition findOneByName(String name);
}
