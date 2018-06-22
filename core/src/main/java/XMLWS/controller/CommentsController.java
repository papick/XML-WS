package XMLWS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Comment;
import XMLWS.repository.CommentRepository;
import XMLWS.service.AccomodationService;
import XMLWS.service.CommentService;

@RestController
@RequestMapping(value = "/api/comments")
public class CommentsController {

	@Autowired
	private CommentService commService;

	@Autowired
	private CommentRepository commRepo;

	@Autowired
	private AccomodationService accService;

	@GetMapping("/get-comments")
	public ResponseEntity<List<Comment>> getComments() {

		List<Comment> c = commService.getDeniedComments();

		return new ResponseEntity<List<Comment>>(c, HttpStatus.OK);
	}

	@PutMapping("/approve-comment/{id}")
	public void approveComment(@PathVariable Long id) {
		commService.approveComment(id);
	}

	@DeleteMapping("/delete-comment/{id}")
	public void deleteComment(@PathVariable Long id) {
		commService.deleteComment(id);
	}

	@GetMapping("/get-comments-acc/{idAcc}")
	public ResponseEntity<List<Comment>> getCommentsForAcc(@PathVariable Long idAcc) {

		List<Comment> c = commRepo.findByAccommodation(accService.getAccomodation(idAcc));
		List<Comment> listOfComments = new ArrayList<Comment>();

		for (Comment comm : c) {
			if (comm.isApproved() == true) {
				listOfComments.add(comm);
			}
		}

		return new ResponseEntity<List<Comment>>(listOfComments, HttpStatus.OK);
	}
	
	@PostMapping("/add-comment")
	public ResponseEntity<Comment> addComment(@RequestBody Comment c) {

		Comment commForAdd = commService.addComment(c);
		return new ResponseEntity<Comment>(commForAdd, HttpStatus.OK);
	}

}
