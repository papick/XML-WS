package agent.service;

import java.util.ArrayList;
import java.util.List;

import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Agent;
import agent.model.Message;
import agent.model.Response;
import agent.model.User;
import agent.repository.AgentRepository;
import agent.repository.MessageRepository;
import agent.repository.ResponseRepository;
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

	@Autowired
	private ResponseRepository responseRepository;

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

		Response answer = new Response();
		answer.setSender(agent);
		answer.setRecipient(user);
		answer.setText(answerDTO.getText());
		responseRepository.save(answer);

		if (message.getResponses().isEmpty()) {
			ArrayList<Response> answers = new ArrayList<Response>();
			answers.add(answer);
			message.setResponses(answers);
			messageRepository.save(message);

		} else {
			message.getResponses().add(answer);
			messageRepository.save(message);

		}
	}

}
