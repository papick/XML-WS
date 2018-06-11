package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Comment;

@Service
public interface CommentService {

	public List<Comment> getAllComments();

	public Comment addComment(Comment c);

	public Comment modifyComment(Comment c, Long id);

	public void deleteComment(Long id);

}
