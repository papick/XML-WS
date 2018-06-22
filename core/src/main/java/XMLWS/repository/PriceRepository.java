package XMLWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
