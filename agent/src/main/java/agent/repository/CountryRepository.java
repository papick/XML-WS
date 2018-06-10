package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
