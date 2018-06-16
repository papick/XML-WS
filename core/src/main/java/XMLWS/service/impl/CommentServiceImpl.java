package XMLWS.service.impl;

import java.util.ArrayList;
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

	@Override
	public Comment getComment(Long id) {
		return commRepo.findOne(id);
	}

	@Override
	public List<Comment> getApprovedComments() {
		List<Comment> allComments = this.getAllComments();
		List<Comment> approvedComments = new ArrayList<Comment>();

		for (Comment c : allComments) {
			if (c.isApproved() == true) {
				approvedComments.add(c);
			}
		}

		return approvedComments;
	}

	@Override
	public List<Comment> getDeniedComments() {
		List<Comment> allComments = this.getAllComments();
		List<Comment> deniedComments = new ArrayList<Comment>();

		for (Comment c : allComments) {
			if (c.isApproved() == false) {
				deniedComments.add(c);
			}
		}

		return deniedComments;

	}

	@Override
	public void approveComment(Long id) {
		Comment c = this.getComment(id);
		if (c.isApproved() == false) {
			c.setApproved(true);
			commRepo.save(c);
		}
	}

}
