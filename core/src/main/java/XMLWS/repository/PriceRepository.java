package XMLWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	List<Price> findByAccomodationId(Long id);

}
