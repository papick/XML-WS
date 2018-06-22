package XMLWS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Accommodation;
import XMLWS.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	public List<Comment> findByAccommodation(Accommodation acc);

}
