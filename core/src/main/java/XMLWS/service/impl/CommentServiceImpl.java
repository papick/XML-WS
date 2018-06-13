package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Comment;
import XMLWS.repository.CommentRepository;
import XMLWS.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commRepo;

	@Override
	public List<Comment> getAllComments() {
		return (List<Comment>) commRepo.findAll();

	}

	@Override
	public Comment addComment(Comment c) {
		Comment newComment = new Comment();
		newComment.setAccommodation(c.getAccommodation());// ispravi
		newComment.setApproved(false);
		newComment.setNameOfUser(c.getNameOfUser());
		newComment.setText(c.getText());
		return commRepo.save(newComment);
	}

	@Override
	public Comment modifyComment(Comment c, Long id) {
		Comment updated = commRepo.findOne(id);
		updated.setText(c.getText());
		return commRepo.save(updated);
	}

	@Override
	public void deleteComment(Long id) {
		Comment commForDelete = commRepo.findOne(id);
		if (commForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant comment");
		}
		commRepo.delete(commForDelete);
	}

}
