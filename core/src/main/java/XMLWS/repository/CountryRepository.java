package XMLWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
