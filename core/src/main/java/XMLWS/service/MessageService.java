package XMLWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Agent;
import XMLWS.model.Message;
import XMLWS.model.MessageAgent;
import XMLWS.model.User;
import XMLWS.repository.AgentRepository;
import XMLWS.repository.MessageAgentRepository;
import XMLWS.repository.MessageRepository;
import XMLWS.repository.ResponseRepository;
import XMLWS.repository.UserRepository;
import XMLWS.service.dto.MessageDTO;

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
	
	@Autowired
	private MessageAgentRepository messageAgentRepository;

	public List<Message> getAllMessages(String username) {
		User user = userRepository.findByUsername(username);
		return messageRepository.findAllBySender(user);
	}

	public void message(MessageDTO messageDTO) {

		Agent agent = agentRepository.findOne(Long.parseLong(messageDTO.getReceipient()));
		User user = userRepository.findByUsername(messageDTO.getSender());

		Message message = new Message();
		message.setRecipient(agent);
		message.setSender(user);
		message.setText(messageDTO.getText());
		messageRepository.save(message);
		
		MessageAgent messageAgent = new MessageAgent();
		messageAgent.setMessage(message);
		messageAgent.setAgent(message.getRecipient());
		messageAgentRepository.save(messageAgent);

	}

}
