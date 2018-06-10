package agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
