package agent.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agent.model.Accommodation;
import agent.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	ArrayList<Comment> findAllByAccommodation(Accommodation acc);

}
