package XMLWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import XMLWS.model.Period;

public interface PeriodRepository extends JpaRepository<Period, Long> {

	public List<Period> findByAccomodationId(Long accomodationId);

	}
