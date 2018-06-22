package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agent.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long>{ 

}
