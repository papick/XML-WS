package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Message;
import XMLWS.service.MessageService;
import XMLWS.service.dto.MessageDTO;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/all-messages/{username}")
	public ResponseEntity<List<Message>> getMessages(@PathVariable String username) {
		List<Message> message = messageService.getAllMessages(username);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/new-message")
	public void createAnswer(@RequestBody MessageDTO messageDTO) {
		messageService.message(messageDTO);

	}
}
