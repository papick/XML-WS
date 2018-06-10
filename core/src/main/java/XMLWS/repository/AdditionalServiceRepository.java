package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.AdditionalService;

@Repository
public interface AdditionalServiceRepository extends CrudRepository<AdditionalService, Long>{

}
