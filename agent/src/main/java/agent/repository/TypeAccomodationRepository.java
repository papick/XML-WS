package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.TypeAccomodation;

@Repository
public interface TypeAccomodationRepository extends JpaRepository<TypeAccomodation, Long> {

	TypeAccomodation findOneByName(String name);
}
