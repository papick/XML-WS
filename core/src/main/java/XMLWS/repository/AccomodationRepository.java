package XMLWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Accommodation;

@Repository
public interface AccomodationRepository extends JpaRepository<Accommodation, Long>{

}
