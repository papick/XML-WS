package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;

import XMLWS.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}