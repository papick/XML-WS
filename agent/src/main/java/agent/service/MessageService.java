package agent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Agent;
import agent.model.Message;
import agent.model.User;
import agent.repository.AgentRepository;
import agent.repository.MessageRepository;
import agent.repository.UserRepository;
import agent.service.dto.AnswerDTO;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AgentRepository agentRepository;

	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public void answer(AnswerDTO answerDTO) {
		System.out.println(" aaaa  " + answerDTO.getIdMessage() + answerDTO.getReceipient() + answerDTO.getSender()
				+ answerDTO.getText());

		Long idMessage = Long.parseLong(answerDTO.getIdMessage());
		Message message = messageRepository.findOne(idMessage);

		Agent agent = agentRepository.findOneByUsername(answerDTO.getSender());
		Long idUser = Long.parseLong(answerDTO.getReceipient());
		User user = userRepository.findOne(idUser);

		Message answer = new Message();
		answer.setRecipient(agent);
		answer.setSender(user);
		answer.setText(answerDTO.getText());
		messageRepository.save(answer);

		if (message.getMessages().isEmpty()) {
			ArrayList<Message> answers = new ArrayList<Message>();
			answers.add(answer);
			message.setMessages(answers);
			messageRepository.save(message);

		} else {
			message.getMessages().add(answer);
			messageRepository.save(message);

		}
	}

}
