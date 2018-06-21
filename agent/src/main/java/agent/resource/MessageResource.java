package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Message;
import agent.service.MessageService;
import agent.service.dto.AnswerDTO;

@RestController
@RequestMapping(value = "/api/message")
public class MessageResource {

	@Autowired
	private MessageService messageService;

	@GetMapping("/all-messages")
	public ResponseEntity<List<Message>> getMessages() {
		List<Message> message = messageService.getAllMessages();
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/answer")
	public void createAnswer(@RequestBody AnswerDTO answerDTO) {
		messageService.answer(answerDTO);

	}
}
