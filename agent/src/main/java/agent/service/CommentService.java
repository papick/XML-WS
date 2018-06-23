package agent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Accommodation;
import agent.model.Comment;
import agent.repository.AccomodationRepository;
import agent.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRpository;

	@Autowired
	private AccomodationRepository accomdoationRepository;

	public ArrayList<Comment> getAllComments(Long id) {
		Accommodation acc = accomdoationRepository.findOne(id);
		return commentRpository.findAllByAccommodation(acc);
	}
}
