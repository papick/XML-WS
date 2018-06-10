package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.City;
@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	City findOneByName(String name);
}
