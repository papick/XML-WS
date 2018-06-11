package XMLWS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
