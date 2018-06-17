package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Comment;
import XMLWS.service.CommentService;

@RestController
@RequestMapping(value = "/api/comments")
public class CommentsController {
	
	@Autowired
	private CommentService commService;
	
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

}
