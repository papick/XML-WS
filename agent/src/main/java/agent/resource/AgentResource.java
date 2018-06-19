package agent.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Agent;
import agent.resource.response.LogInResponse;
import agent.service.AgentService;
import agent.service.dto.AgentDTO;



@RestController
@RequestMapping(value = "/api/agent")
public class AgentResource {

	@Autowired
	private AgentService agentService;

	@PutMapping("/log-in")
	public ResponseEntity<LogInResponse> logIn(@RequestBody AgentDTO agentDTO) {

		Agent agent = agentService.logIn(agentDTO);

		return new ResponseEntity<>(new LogInResponse(agent), HttpStatus.OK);
	}
}
