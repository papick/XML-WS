package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

}
