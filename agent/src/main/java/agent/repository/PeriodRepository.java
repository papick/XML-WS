package agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Accommodation;
import agent.model.Period;


@Repository
public interface PeriodRepository extends JpaRepository<Period, Long>{

	List<Period> findByAccomodation(Accommodation acc);
}
