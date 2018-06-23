package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Addition;

@Repository
public interface AdditionalServiceRepository extends CrudRepository<Addition, Long> {
	Addition findOneByName(String name);
}
