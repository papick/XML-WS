package XMLWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Message;
import XMLWS.model.User;



@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findAllBySender(User user);
}
