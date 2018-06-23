package agent.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import agent.model.Accommodation;
import agent.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long>{ 

	ArrayList<Price> findAllByAccomodation(Accommodation acc);
}
