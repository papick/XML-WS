package XMLWS.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import XMLWS.model.Period;

public interface PeriodRepository extends JpaRepository<Period, Long>{

	public List<Period> findByAccomodationId(Long accomodationId);
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

	
>>>>>>> 68d9210c53362937e235945517efe8bc6049a277
}
