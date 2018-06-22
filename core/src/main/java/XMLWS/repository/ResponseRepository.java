package XMLWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

}
