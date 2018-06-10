package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.TypeAccomodation;

@Repository
public interface TypeAccomodationRepository extends CrudRepository<TypeAccomodation, Long>{

}
