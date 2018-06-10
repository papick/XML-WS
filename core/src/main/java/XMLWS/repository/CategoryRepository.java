package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
