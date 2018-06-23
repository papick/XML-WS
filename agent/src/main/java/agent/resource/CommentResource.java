package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Comment;
import agent.service.CommentService;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentResource {

	@Autowired
	private CommentService commentService;

	@GetMapping("/all-comment-for-accomodation/{id}")
	public ResponseEntity<List<Comment>> getComments(@PathVariable Long id) {
		List<Comment> comments = commentService.getAllComments(id);
		return new ResponseEntity<>(comments, HttpStatus.OK);

	}

}
