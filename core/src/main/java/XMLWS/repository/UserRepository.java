package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}